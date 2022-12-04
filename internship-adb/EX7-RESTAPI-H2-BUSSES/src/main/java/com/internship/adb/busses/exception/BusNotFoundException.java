package com.internship.adb.busses.exception;

public class BusNotFoundException extends BusException{
    public BusNotFoundException(String id) {
        super("Bus with id: [" + id + "] not found.");
    }
}