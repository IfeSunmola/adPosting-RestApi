package com.example.adpostingrestapi.User.Annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidPhoneNumberConfig implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        //(123)456-7892
        String pattern = "^[(]\\d*[)]\\d*-\\d*$";
        phoneNumber = phoneNumber.replaceAll(" ", "").strip();
        if(phoneNumber.strip().length() == 13){
            return Pattern.matches(pattern, phoneNumber.replaceAll(" ", ""));
        }
        return false;
    }
}
