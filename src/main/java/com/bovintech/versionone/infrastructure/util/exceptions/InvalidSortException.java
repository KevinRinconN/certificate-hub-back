package com.bovintech.versionone.infrastructure.util.exceptions;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidSortException extends RuntimeException {
    private final String message;
    public InvalidSortException(String message) {
        super(message);
        this.message = message;
    }
}
