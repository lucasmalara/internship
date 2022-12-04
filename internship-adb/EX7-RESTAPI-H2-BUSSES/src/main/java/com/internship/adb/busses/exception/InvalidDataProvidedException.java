package com.internship.adb.busses.exception;

public class InvalidDataProvidedException extends RuntimeException {
    public static final String VALIDATE_PROVIDED_DATA = "Something went wrong. Validate provided data.";

    public InvalidDataProvidedException() {
        super(VALIDATE_PROVIDED_DATA);
    }
}