package com.bovintech.versionone.domain.util.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneFieldValidator.class)
public @interface AtLeastOneField {
    String[] fields(); // Los campos que deben ser verificados
    String message() default "Debe especificar al menos uno de los campos requeridos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
