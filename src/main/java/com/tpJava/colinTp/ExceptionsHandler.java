package com.tpJava.colinTp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;


@RestControllerAdvice
public class ExceptionsHandler {


    //handle 404
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String EntityNotFoundExceptionHandler(EntityNotFoundException e){
        return e.getMessage();
    }

    //handle 409
    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String EntityExistsException(EntityExistsException e){
        return e.getMessage();
    }
}
