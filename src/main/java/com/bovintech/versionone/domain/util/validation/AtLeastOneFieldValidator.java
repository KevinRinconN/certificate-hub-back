package com.bovintech.versionone.domain.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Arrays;

public class AtLeastOneFieldValidator implements ConstraintValidator<AtLeastOneField, Object> {
    private String[] fields;
    private String message;

    @Override
    public void initialize(AtLeastOneField constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean atLeastOnePresent = Arrays.stream(fields)
                .anyMatch(fieldName -> {
                    try {
                        Field field = value.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return field.get(value) != null;
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        return false;
                    }
                });

        if (!atLeastOnePresent) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();
        }

        return atLeastOnePresent;
    }
}
