package com.backend.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    // intercepter the exception and return a custom response
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerProductNotFoundException(ProductNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());    
        errorMessage.setTimestamp(new Date());
        
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerReviewNotFoundException(ReviewNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimestamp(new Date());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerReviewNotFoundException(DepartmentNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimestamp(new Date());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
