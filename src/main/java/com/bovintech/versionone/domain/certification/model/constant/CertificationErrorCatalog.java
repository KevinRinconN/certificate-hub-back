package com.bovintech.versionone.domain.certification.model.constant;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum CertificationErrorCatalog implements ErrorCode {
    CERTIFICATION_NOT_FOUND("CNFI", "El certificado no fue encontrado"),
    CERTIFICATION_QR_INVALID("CQRI", "Qr invalido");

    private final String code;
    private final String message;

    CertificationErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
