package com.example.adpostingrestapi.User.Annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {IsLegalConfig.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsLegal {
    int minimumAge();
    String message();
    Class<?> []groups() default {};
    Class<? extends Payload> [] payload() default {};
}
