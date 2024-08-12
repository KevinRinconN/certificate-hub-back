package com.bovintech.versionone.infrastructure.util;

import com.bovintech.versionone.domain.util.exception.NotFoundException;
import com.bovintech.versionone.infrastructure.util.exceptions.InvalidSortException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception, WebRequest webRequest) {
        BindingResult result = exception.getBindingResult();

        // Extraer errores a nivel de objeto
        List<String> details = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("INVD")
                .message("La solicitud enviada contiene datos inválidos")
                .details(details)
                .path(webRequest.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGlobalNotFoundException(NotFoundException exception, WebRequest webRequest){
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .details(Collections.singletonList(exception.getDetailsMessage()))
                .path(webRequest.getDescription(false).replace("uri=",""))
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidSortException.class)
    public ResponseHandler<ErrorResponse> handleInvalidSortException (InvalidSortException exception, WebRequest webRequest) {
        return ResponseHandler.error(
                "Invalid sort",
                Collections.singletonList(exception.getMessage()),
                "IS",
                webRequest.getDescription(false).replace("uri=","")
        );
    }
}
