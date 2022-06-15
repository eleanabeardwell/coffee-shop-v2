package com.eleana.coffeeshop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.ServiceUnavailableException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<Object> handleProductNotFoundException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(
                "Product not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ProductIdAlreadyExistsException.class})
    public ResponseEntity<Object> handleProductIdAlreadyExistsException(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(
                "A product with that id already exists, please try again.", new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<Object> handleServiceUnavailableExcpetion(Exception exception, WebRequest request) {
        return new ResponseEntity<Object>(
                "Service currently unavailable, please try again.", new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
    }

}
