package com.example.coachMeUp.exceptions.errors;

public class InvalidFieldsException extends RuntimeException{
    public InvalidFieldsException(String message) {
        super(message);
    }

    public InvalidFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}
