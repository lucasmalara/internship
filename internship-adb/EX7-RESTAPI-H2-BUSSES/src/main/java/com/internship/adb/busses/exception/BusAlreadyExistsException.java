package com.internship.adb.busses.exception;

public class BusAlreadyExistsException extends BusException {
    public BusAlreadyExistsException(String id) {
        super("Bus with id: [" + id + "] already exists.");
    }
}