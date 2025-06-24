package com.bovintech.versionone.infrastructure.company.rest.advice;

import com.bovintech.versionone.domain.certification.model.exception.CertificationNotFoundException;
import com.bovintech.versionone.domain.company.model.exception.CompanyBadRequest;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.infrastructure.util.ErrorResponse;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;

@ControllerAdvice
public class CompanyControllerAdvice {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseHandler<ErrorResponse> handleCompanyNotFound(CompanyNotFoundException exception, WebRequest webRequest){
        return ResponseHandler.error(
                exception.getMessage(),
                Collections.singletonList(exception.getDetailsMessage()),
                exception.getCode(),
                webRequest.getDescription(false).replace("uri=","")
        );
    }

    @ExceptionHandler(CompanyBadRequest.class)
    public ResponseHandler<ErrorResponse> handleCompanyBadRequest(CompanyBadRequest exception, WebRequest webRequest){
        return ResponseHandler.error(
                exception.getMessage(),
                Collections.singletonList(exception.getDetailsMessage()),
                exception.getCode(),
                webRequest.getDescription(false).replace("uri=","")
        );
    }
}
