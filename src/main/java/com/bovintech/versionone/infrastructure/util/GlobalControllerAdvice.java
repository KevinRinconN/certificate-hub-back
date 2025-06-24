package com.bovintech.versionone.infrastructure.util;

import com.bovintech.versionone.domain.util.exception.NotFoundException;
import com.bovintech.versionone.infrastructure.util.exceptions.InvalidSortException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException exception, WebRequest webRequest) {

        // Extraer los errores de la excepción ConstraintViolationException
        List<String> details = exception.getConstraintViolations()
                .stream()
                .map(violation -> {
                    String fieldName = violation.getPropertyPath().toString();
                    // Extraer solo el nombre del campo sin la ruta completa
                    fieldName = fieldName.substring(fieldName.lastIndexOf('.') + 1);
                    return fieldName + ": " + violation.getMessage();
                })
                .collect(Collectors.toList());

        // Construir el objeto ErrorResponse con los detalles de la validación
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code("INVD")
                .message("La solicitud enviada contiene datos inválidos")
                .details(details)
                .path(webRequest.getDescription(false).replace("uri=", ""))
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception, WebRequest webRequest) {
        BindingResult result = exception.getBindingResult();
        // Extraer errores a nivel de objeto
        List<String> details = result.getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
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
