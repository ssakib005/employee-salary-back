package com.company.employee.exception;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, NullPointerException.class})
    public ResponseEntity<String> handlyMyCustomException(MethodArgumentNotValidException e, NullPointerException n) {
        return new ResponseEntity<>("Something happened: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}