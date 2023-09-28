package com.example.customerservice.exceptions.errors;

public class InvalidFieldsException extends RuntimeException{
    public InvalidFieldsException(String message) {
        super(message);
    }

    public InvalidFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}
