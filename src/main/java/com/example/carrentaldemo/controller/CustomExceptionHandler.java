package com.example.carrentaldemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        System.out.println("***   ****    we are here   ****   ****");
        ex.getBindingResult().getAllErrors().forEach((error) -> {

//            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put("message", message);

        });
        errors.put("status","false");
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
