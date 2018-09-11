package com.spring.demand.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UpdateException.class)
    public ResponseEntity<Error> updateFailed(UpdateException e){
        Error error = new Error(500 , "update failed");
        return new ResponseEntity<Error>(error,HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(InsertException.class)
    public ResponseEntity<Error> insertFailed(InsertException e){
        Error error = new Error(500 , "some fields are null");
        return new ResponseEntity<Error>(error,HttpStatus.SERVICE_UNAVAILABLE);
    }
}
