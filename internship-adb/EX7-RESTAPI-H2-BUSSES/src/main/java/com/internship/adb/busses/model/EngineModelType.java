package com.internship.adb.busses.model;

public enum EngineModelType {
    ELECTRIC, DIESEL;

    public static EngineModelType convertFromString(String s) {
        return EngineModelType.valueOf(s.toUpperCase());
    }
}