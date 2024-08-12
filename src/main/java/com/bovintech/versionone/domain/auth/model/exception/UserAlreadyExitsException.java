package com.bovintech.versionone.domain.auth.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;
import lombok.Getter;

@Getter
public class UserAlreadyExitsException extends GlobalExeception {

    private final String message;

    public UserAlreadyExitsException(ErrorCode error, String message) {
        super(error.getCode(),message);
        this.message = error.getMessage();
    }
}
