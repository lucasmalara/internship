package com.internship.adb.beans.cooling.systems.template;

public interface CoolingSystem {
    void turnOn();
    boolean isOn();
    void turnOff();
    boolean isOff();
    int getDegrees();
    void changeTemperature(int arg);
}