package com.bovintech.versionone.infrastructure.certification.rest.advice;

import com.bovintech.versionone.domain.certification.model.exception.CertificationNotFoundException;
import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import com.bovintech.versionone.infrastructure.util.exceptions.InvalidSortException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@ControllerAdvice
public class CertificationControllerAdvice {
    @ExceptionHandler(CertificationNotFoundException.class)
    public ResponseHandler<ErrorResponse> handleCertificationNotFound(CertificationNotFoundException exception, WebRequest webRequest){
        return ResponseHandler.error(
                exception.getMessage(),
                Collections.singletonList(exception.getDetailsMessage()),
                exception.getCode(),
                webRequest.getDescription(false).replace("uri=","")
        );
    }
}
