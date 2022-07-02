package com.example.adpostingrestapi.User.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
/*
 * This class handles any exception thrown from the UserController class
 * Each method returns a hash map (json) with the error message
 * */
public class UserExceptionHandler {
    /*
     * Handles what should be returned when InvalidParametersException is thrown.
     * InvalidParametersException will be thrown invalid arguments is sent as a request body
     * Get the field errors, for each error, put to map.
     * **Map will be automatically converted to JSON**
     * */
    @ExceptionHandler
    public ResponseEntity<HashMap<String, String>> invalidParameters(InvalidParametersException ex) {
        System.out.println("RUNNINGNGNGN");
        HashMap<String, String> errorMap = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
