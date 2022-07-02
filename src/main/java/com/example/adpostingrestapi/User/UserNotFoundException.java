package com.example.adpostingrestapi.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private final String resource;// username or id

    public UserNotFoundException(String resource, String username) {
        super(String.format("%s '%s' was not found", resource, username));
        this.resource = resource;
    }

    public UserNotFoundException(String resource, long id) {
        super(String.format("%s '%d' was not found", resource, id));
        this.resource = resource;
    }
}
