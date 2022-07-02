package com.example.adpostingrestapi.User.Annotations;

import com.example.adpostingrestapi.User.UserRegistrationDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchConfig implements ConstraintValidator<FieldMatch, UserRegistrationDto> {

    @Override
    public boolean isValid(UserRegistrationDto userRegistrationDto, ConstraintValidatorContext constraintValidatorContext) {
        return userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword()) ;
    }
}
