package com.bovintech.versionone.domain.certification.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;
import lombok.Getter;

@Getter
public class CertificationQrInvalidException  extends GlobalExeception {
    private final String message;

    public CertificationQrInvalidException(ErrorCode error, String message) {
        super(message,error.getCode());
        this.message = error.getMessage();
    }
}
