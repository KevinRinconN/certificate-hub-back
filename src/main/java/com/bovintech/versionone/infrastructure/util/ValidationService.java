package com.bovintech.versionone.infrastructure.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
@RequiredArgsConstructor
public class ValidationService {

    private final Validator validator;

    public <T> void validate(T object, String objectName) throws MethodArgumentNotValidException {
        BindException errors = new BindException(object, objectName);
        validator.validate(object, errors);
        if (errors.hasErrors())  throw new MethodArgumentNotValidException(null, errors);
    }
}
