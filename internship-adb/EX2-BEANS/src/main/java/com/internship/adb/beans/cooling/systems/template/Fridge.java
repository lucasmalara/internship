package com.internship.adb.beans.cooling.systems.template;

public class Fridge implements CoolingSystem {

    private boolean isOn;
    private int degrees;
    private boolean isFreezingModeOn;
    private static final int DOWN_LIMIT = -15;
    private static final int UP_LIMIT = 5;
    private static final int THRESHOLD_TO_FREEZING_MODE = ((DOWN_LIMIT + UP_LIMIT) / 2) - 1;

    public static int getMinDegree() {
        return DOWN_LIMIT;
    }

    public static int getMaxDegree() {
        return UP_LIMIT;
    }

    public boolean isInFreezingMode() {
        return this.isOn && isFreezingModeOn;
    }

    private void freezingModeSwitcher(boolean freezingModeSetByUser) {
        this.isFreezingModeOn = freezingModeSetByUser;
        String basicMassage = "Freezing function has been turned %s%s";
        if (freezingModeSetByUser) {
            System.out.printf(basicMassage, "on.", "\n");
        } else System.out.printf(basicMassage, "off.", "\n") ;
    }

    public void setToFreezingMode(boolean freezingModeSetByUser) {
        if (this.isOn && this.isFreezingModeOn != freezingModeSetByUser) {
            this.degrees = freezingModeSetByUser ?
                    THRESHOLD_TO_FREEZING_MODE - 1 : THRESHOLD_TO_FREEZING_MODE + 1;
            freezingModeSwitcher(freezingModeSetByUser);
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
            System.out.println("The fridge is turning on...");
            System.out.println("Wait a bit...");
            this.isOn = true;
            System.out.println("It's on!");
        }
    }

    @Override
    public void turnOff() {
        if (this.isOn) {
            System.out.println("The fridge is turning off...");
            System.out.println("Wait a bit...");
            this.isOn = false;
            System.out.println("It's off!");
        }
    }

    @Override
    public void changeTemperature(int degrees) {
        if (this.isOn && this.degrees != degrees) {
            if (degrees >= DOWN_LIMIT && degrees <= UP_LIMIT) {
                this.degrees = degrees;
                System.out.println("The temperature has been changed to " + degrees + " degrees Celsius.");
                freezingModeSwitcher(degrees < THRESHOLD_TO_FREEZING_MODE);
            } else System.out.println("You are allowed to set degrees Celsius between "
                    + DOWN_LIMIT + " and " + UP_LIMIT + " only.");
        }
    }
}