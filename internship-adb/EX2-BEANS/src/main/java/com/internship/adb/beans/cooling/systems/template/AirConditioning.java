package com.internship.adb.beans.cooling.systems.template;

import org.springframework.beans.factory.annotation.Autowired;

public class AirConditioning implements CoolingSystem {

    private boolean isOn;
    private int degrees;
    private boolean isExtraCoolingOn;
    private final boolean isMobile;
    private static final int DOWN_LIMIT = 5;
    private static final int UP_LIMIT = 18;
    private static final int THRESHOLD_EXTRA_COOLING_MODE = ((UP_LIMIT - DOWN_LIMIT) / 2) + DOWN_LIMIT;

    @Autowired
    public AirConditioning(boolean mobility) {
        this.isMobile = mobility;
    }

    public static int getMinDegreeLimit() {
        return DOWN_LIMIT;
    }

    public static int getMaxDegreeLimit() {
        return UP_LIMIT;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public boolean isInExtraCoolingMode() {
        return this.isOn && isExtraCoolingOn;
    }

    public boolean isInBasicCoolingMode() {
        return this.isOn && !isExtraCoolingOn;
    }

    private void extraCoolingModeSwitcher() {
        this.isExtraCoolingOn = true;
        System.out.println("Extra-cooling mode has been set on.");
    }

    public void setToExtraCoolingMode() {
        if (isInBasicCoolingMode()) {
            if (this.degrees >= THRESHOLD_EXTRA_COOLING_MODE) {
                this.degrees = THRESHOLD_EXTRA_COOLING_MODE - 1;
            }
            extraCoolingModeSwitcher();
        }
    }

    private void basicCoolingModeSwitcher() {
        this.isExtraCoolingOn = false;
        System.out.println("Basic-cooling mode has been set on.");
    }

    public void setToBasicCoolingMode() {
        if (isInExtraCoolingMode()) {
            if (this.degrees <= THRESHOLD_EXTRA_COOLING_MODE) {
                this.degrees = THRESHOLD_EXTRA_COOLING_MODE + 1;
            }
            basicCoolingModeSwitcher();
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public boolean isOff() {
        return !isOn;
    }

    @Override
    public int getDegrees() {
        return this.isOn ? this.degrees : 0;
    }

    @Override
    public void turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            System.out.println("Turned on air conditioning.");
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn) {
            this.isOn = false;
            System.out.println("Turned off air conditioning.");
        }
    }

    @Override
    public void changeTemperature(int degrees) {
        if (this.isOn && this.degrees != degrees) {
            if (degrees >= DOWN_LIMIT && degrees <= UP_LIMIT) {
                this.degrees = degrees;
                System.out.println("The temperature has been changed to " + degrees + " degrees Celsius.");
                if (degrees < THRESHOLD_EXTRA_COOLING_MODE) {
                    extraCoolingModeSwitcher();
                } else basicCoolingModeSwitcher();
            } else System.out.println("You are allowed to set degrees Celsius between "
                    + DOWN_LIMIT + " and " + UP_LIMIT + " only.");
        }
    }
}