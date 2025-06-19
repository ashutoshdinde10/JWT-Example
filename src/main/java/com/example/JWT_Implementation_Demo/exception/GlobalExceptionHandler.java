package com.example.JWT_Implementation_Demo.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();

        errors.put("error", ex.getBindingResult().getFieldError().getDefaultMessage());
        errors.put("code", ex.getStatusCode());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Map<String, Object>> appException(AppException ex) {
        Map<String, Object> exceptionResponse = new HashMap<>();
        exceptionResponse.put("error", ex.getMessage());
        exceptionResponse.put("code", ex.getErrorCode());

        return new ResponseEntity<>(exceptionResponse, ex.getStatusCode());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> handleAuthenticationException(AuthenticationException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("error", "Invalid email or password");
        return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, Object> response = new HashMap<>();

        String detailedMessage = ex.getMostSpecificCause().getMessage();

        String userMessage;
        if (detailedMessage.contains("user_email")) {
            userMessage = "Email already exists.";
        } else if (detailedMessage.contains("user_name")) {
            userMessage = "Username cannot be null.";
        } else if (detailedMessage.contains("user_password")) {
            userMessage = "Password cannot be null.";

        } else {
            userMessage = "Invalid request: data integrity violated.";
        }

        response.put("error", userMessage);
        response.put("code", HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(IllegalArgumentException ex) {
        Map<String, Object> response = new HashMap<>();

        String detailedMessage = ex.getMessage();

        String userMessage;
        if (detailedMessage.contains("rawPassword")) {
            userMessage = "Password cannot be null.";
        } else {
            userMessage = "Invalid request: data integrity violated.";
        }

        response.put("error", userMessage);
        response.put("code", HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
