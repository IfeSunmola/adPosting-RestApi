package com.example.adpostingrestapi.User.Annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IsLegalConfig implements ConstraintValidator<IsLegal, LocalDate> {
    private int minimumAge;

    @Override
    public void initialize(IsLegal constraintAnnotation) {
        minimumAge = constraintAnnotation.minimumAge();
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        return dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS) >= minimumAge;
    }
}
