package com.internship.adb.busses.exception;

public class RequestNotValidException extends RuntimeException {
    public static final String VALIDATE_PROVIDED_DATA = "Something went wrong. Validate request. Caused By: ";

    public RequestNotValidException(String cause) {
        super(VALIDATE_PROVIDED_DATA + cause);
    }
}