package com.bovintech.versionone.domain.certification.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;
import lombok.Getter;

@Getter
public class CertificationNotFoundException extends GlobalExeception {
    private final String message;
    public CertificationNotFoundException(ErrorCode error, String message) {
        super(message,error.getCode());
        this.message = error.getMessage();
    }
}
