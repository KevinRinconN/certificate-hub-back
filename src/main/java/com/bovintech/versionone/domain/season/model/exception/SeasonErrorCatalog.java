package com.bovintech.versionone.domain.season.model.exception;

import com.bovintech.versionone.domain.util.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SeasonErrorCatalog implements ErrorCode {
    SEASON_BY_ID_NOT_FOUND("SNF", "Temporada no encontrada"),
    SEASON_BAD_REQUEST("SBR","Ups!, Algo salio mal");

    private final String code;
    private final String message;
}

