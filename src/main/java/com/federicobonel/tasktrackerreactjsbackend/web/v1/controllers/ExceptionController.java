package com.federicobonel.tasktrackerreactjsbackend.web.v1.controllers;

import com.federicobonel.tasktrackerreactjsbackend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> resourceNotFound() {
        return new ResponseEntity<>("Resource not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
