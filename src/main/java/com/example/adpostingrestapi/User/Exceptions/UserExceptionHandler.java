package com.example.adpostingrestapi.User.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
/*
 * This class handles any exception thrown from the UserController class
 * Each method returns a hash map (json) with the error message
 * */
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<HashMap<String, String>> invalidRequestBody(InvalidParametersException ex) {
        HashMap<String, String> errorMap = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<HashMap<String, String>> userNotFound(UsernameNotFoundException ex) {
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("Error Message", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }
}
