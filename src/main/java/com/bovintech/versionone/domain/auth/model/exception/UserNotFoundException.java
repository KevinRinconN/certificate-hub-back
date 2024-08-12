package com.bovintech.versionone.domain.auth.model.exception;

import com.bovintech.versionone.domain.auth.model.constant.UserErrorCatalog;
import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;

public class UserNotFoundException extends GlobalExeception {
    private final String message;
    public UserNotFoundException(ErrorCode error, String message) {
        super(error.getCode(),message);
        this.message = error.getMessage();
    }
}
