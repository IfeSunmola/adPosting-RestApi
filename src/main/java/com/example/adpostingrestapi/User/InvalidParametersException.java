package com.example.adpostingrestapi.User;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InvalidParametersException extends Exception{
    private List<FieldError> fieldErrors;

    public InvalidParametersException(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public InvalidParametersException(String objectName, String fieldName, String message){
        fieldErrors = new ArrayList<FieldError>(1);
        FieldError fieldError = new FieldError(objectName, fieldName, message);
        fieldErrors.add(fieldError);
    }
}
