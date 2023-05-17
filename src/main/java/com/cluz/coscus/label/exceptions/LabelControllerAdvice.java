package com.cluz.coscus.label.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class LabelControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LabelResourceNotFoundException.class)
    public ResponseEntity<Object> handleLabelResourceNotFoundException(
            LabelResourceNotFoundException ex, WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), Collections.singletonList(ex.getMessage()));
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    @ExceptionHandler(LabelResourceException.class)
    public ResponseEntity<Object> handleLabelResourceException(
            LabelResourceException ex, WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.ALREADY_REPORTED, ex.getMessage(), Collections.singletonList(ex.getMessage()));
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
}
