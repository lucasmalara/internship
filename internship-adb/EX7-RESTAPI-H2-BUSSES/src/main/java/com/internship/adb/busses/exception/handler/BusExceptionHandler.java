package com.internship.adb.busses.exception.handler;

import com.internship.adb.busses.exception.BusAlreadyExistsException;
import com.internship.adb.busses.exception.BusException;
import com.internship.adb.busses.exception.BusNotFoundException;
import com.internship.adb.busses.exception.response.body.ErrorResponse;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusExceptionHandler {
    private static final int BUS_NOT_FOUND = 1;
    private static final int BUS_EXISTS = 2;
    private static final int INVALID_REQUEST = 3;

    @ExceptionHandler(BusException.class)
    public ResponseEntity<ErrorResponse> handleBusExceptions(final BusException exc) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(exc instanceof BusNotFoundException) {
            errorResponse.setCode(BUS_NOT_FOUND);
            status = HttpStatus.NOT_FOUND;
        } else if(exc instanceof BusAlreadyExistsException) {
            errorResponse.setCode(BUS_EXISTS);
            status = HttpStatus.CONFLICT;
        }
            errorResponse.setMessage(exc.getMessage());
        return new ResponseEntity<>(errorResponse,status);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(IllegalArgumentException exc) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(prepareInvalidRequest(exc.getMessage()));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exc) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(prepareInvalidRequest(exc.getMessage()));
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorResponse> handlePropertyValueException(PropertyValueException exc) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(prepareInvalidRequest(exc.getMessage()));
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException exc) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(prepareInvalidRequest("Null not allowed."));
    }

    private ErrorResponse prepareInvalidRequest(String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(INVALID_REQUEST);
        errorResponse.setMessage(message);
        return errorResponse;
    }
}