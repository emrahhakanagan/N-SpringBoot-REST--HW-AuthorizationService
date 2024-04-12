package com.agan.restauthorizationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<?> handleInvalidCredentials(InvalidCredentials invalidCredentials) {
        List<String> details = new ArrayList<>();
        details.add(invalidCredentials.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Invalid Credentials", details);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<?> handleUnauthorizedUser(UnauthorizedUser unauthorizedUser) {
        List<String> details = new ArrayList<>();
        details.add(unauthorizedUser.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Unauthorized User", details);

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errorResponse);
    }

}
