package com.bovintech.versionone.domain.util.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalExeception extends RuntimeException{
    private final String detailsMessage;
    private final String code;

}
