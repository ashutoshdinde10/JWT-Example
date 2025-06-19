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

        errors.put("error",ex.getBindingResult().getFieldError().getDefaultMessage());
        errors.put("code",ex.getStatusCode());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Map<String,Object>> appException(AppException ex){
        Map<String,Object> exceptionResponse = new HashMap<>();
        exceptionResponse.put("error",ex.getMessage());
        exceptionResponse.put("code",ex.getErrorCode());

        return new ResponseEntity<>(exceptionResponse,ex.getStatusCode());
    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<Map<String,Object>> handlerException(AuthenticationException ex) {
//        Map<String,Object> exceptionResponse = new HashMap<>();
//        exceptionResponse.put("error",ex.getMessage());
//        exceptionResponse.put("code",ex.getCause());

//        return new ResponseEntity<>(exceptionResponse,HttpStatus.UNAUTHORIZED);
//    }
@ExceptionHandler(AuthenticationException.class)
public ResponseEntity<Map<String, Object>> handleValidationExceptions(AuthenticationException ex) {
    Map<String, Object> errors = new HashMap<>();

    errors.put("error",ex.getMessage());
//    errors.put("code",ex.getCause());

    return new ResponseEntity<>(errors, HttpStatus.UNAUTHORIZED);
}


}
