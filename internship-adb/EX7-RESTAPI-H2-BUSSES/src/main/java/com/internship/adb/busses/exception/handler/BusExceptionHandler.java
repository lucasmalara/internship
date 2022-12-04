package com.internship.adb.busses.exception.handler;

import com.internship.adb.busses.exception.BusNotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.internship.adb.busses.exception.BusAlreadyExistsException;
import com.internship.adb.busses.exception.InvalidDataProvidedException;
import com.internship.adb.busses.exception.response.body.ErrorResponse;

@RestControllerAdvice
public class BusExceptionHandler {
    private static final int BUS_NOT_FOUND = 1;
    private static final int BUS_EXISTS = 2;
    private static final int INVALID_DATA_PROVIDED = 3;

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBusNotFoundException(final BusNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(BUS_NOT_FOUND);
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleBusAlreadyExistsException(final BusAlreadyExistsException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(BUS_EXISTS);
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidDataProvidedException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDataProvidedException(final InvalidDataProvidedException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(INVALID_DATA_PROVIDED);
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, IllegalArgumentException.class, NullPointerException.class, PropertyValueException.class})
    public ResponseEntity<ErrorResponse> handleOthers() {
       return handleInvalidDataProvidedException(new InvalidDataProvidedException());
    }
}