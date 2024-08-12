package com.bovintech.versionone.domain.company.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import com.bovintech.versionone.domain.util.exception.GlobalExeception;
import lombok.Getter;

@Getter
public class CompanyBadRequest extends GlobalExeception {
    private final String message;
    public CompanyBadRequest(ErrorCode error, String message) {
        super(error.getCode(), message);
        this.message = error.getMessage();
    }
}
