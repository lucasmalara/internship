package com.internship.adb.busses.persistence.entity;

public enum EngineEntityType {
    ELECTRIC, DIESEL;

    public static EngineEntityType convertFromString(String s) {
        return EngineEntityType.valueOf(s.toUpperCase());
    }
}