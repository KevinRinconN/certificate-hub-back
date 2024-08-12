package com.bovintech.versionone.domain.company.model.constant;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CompanyErrorCatalog  implements ErrorCode {
    COMPANY_NOT_FOUND("CNF", "Empresa no encontrada"),

    COMPANY_BAD_REQUEST("CBR","Ups!, Algo salio mal");

    private final String code;
    private final String message;
}

