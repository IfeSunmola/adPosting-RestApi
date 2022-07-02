package com.example.adpostingrestapi.User.Annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {FieldMatchConfig.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface FieldMatch {
    String fieldName ();
    String message() default "Passwords do not match";
    Class<?> []groups() default {};
    Class<? extends Payload> [] payload() default {};
}
