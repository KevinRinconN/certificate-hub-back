package com.bovintech.versionone.domain.Inspector.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InspectorErrorCatalog implements ErrorCode {

    INSPECTOR_BY_ID_NOT_FOUND("INF", "Inspector no encontrada"),
    INSPECTOR_BAD_REQUEST("IBR","Ups!, Algo salio mal");

    private final String code;
    private final String message;
}
