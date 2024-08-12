package com.bovintech.versionone.domain.util.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends GlobalExeception{
    private final String message;
    public NotFoundException(ErrorCode error, String message) {
        super(message,error.getCode());
        this.message = error.getMessage();
    }
}
