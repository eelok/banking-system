package com.petrius.banking_system.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleAccountNotFound(AccountNotFoundException ex, HttpServletRequest request){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getRequestURI(),
                404
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(AccountExistsException.class)
    public ResponseEntity<ErrorDetails> handleAccountExistsException(AccountExistsException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getRequestURI(),
                400
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
