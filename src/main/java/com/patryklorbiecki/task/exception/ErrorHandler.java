package com.patryklorbiecki.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public final ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptableException(
            HttpMediaTypeNotAcceptableException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponse(e.getStatusCode().value(), "Not acceptable: 'Accept' header: 'application/xml"));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotExistingUser() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                "User not found"));
    }
}
