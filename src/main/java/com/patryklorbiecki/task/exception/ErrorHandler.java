package com.patryklorbiecki.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e){
        final ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<ErrorResponse> handleNotAcceptableException(NotAcceptableException e) {
        final ErrorResponse error = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}
