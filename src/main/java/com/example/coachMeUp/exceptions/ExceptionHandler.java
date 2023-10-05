package com.example.coachMeUp.exceptions;

import com.example.coachMeUp.exceptions.errors.*;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Error> objectNotFoundException(ObjectNotFoundException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(LengthException.class)
    public ResponseEntity<Error> lengthException(LengthException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Length exception",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(IvalidFieldsException.class)
    public ResponseEntity<Error> fieldInvalidationException(IvalidFieldsException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Invalid fields parsed",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerAlreadyException.class)
    public ResponseEntity<Error> customerAlreadyException(CustomerAlreadyException ex,
                                                            HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Customer Already Exception",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UndefinedName.class)
    public ResponseEntity<Error> undefinedName(UndefinedName ex,
                                                          HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Course not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UndefinedCategory.class)
    public ResponseEntity<Error> undefinedCategory(UndefinedCategory ex,
                                               HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Category not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmailNotFound.class)
    public ResponseEntity<Error> undefinedCategory(EmailNotFound ex,
                                                   HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Email is not already exception",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity constraintViolationException() {
        return ResponseEntity.badRequest().body("Já existe esse e-mail cadastrado!");
    }
}
