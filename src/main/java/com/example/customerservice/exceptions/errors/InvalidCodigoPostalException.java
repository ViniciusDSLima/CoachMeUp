package com.example.customerservice.exceptions.errors;

public class InvalidCodigoPostalException extends RuntimeException{

    public InvalidCodigoPostalException(String message) {
        super(message);
    }

    public InvalidCodigoPostalException(String message, Throwable cause) {
        super(message, cause);
    }
}
