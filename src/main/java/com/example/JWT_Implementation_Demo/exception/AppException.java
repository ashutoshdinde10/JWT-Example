package com.example.JWT_Implementation_Demo.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private final String errorCode;
    private HttpStatus statusCode;


    public AppException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public AppException(String message, String errorCode, HttpStatus statusCode) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
