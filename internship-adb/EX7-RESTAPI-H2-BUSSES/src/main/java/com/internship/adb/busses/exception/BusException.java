package com.internship.adb.busses.exception;

public abstract class BusException extends RuntimeException {
    protected BusException(String message) {
        super(message);
    }
}