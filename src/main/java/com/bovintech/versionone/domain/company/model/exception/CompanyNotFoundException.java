package com.bovintech.versionone.domain.company.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;
import lombok.Getter;

@Getter
public class CompanyNotFoundException extends GlobalExeception {
    private final String message;
    public CompanyNotFoundException(ErrorCode error, String message) {
        super(error.getCode(),message);
        this.message = error.getMessage();
    }
}

