package com.example.coachMeUp.exceptions.errors;

public class CustomerAlreadyException extends RuntimeException{

    public CustomerAlreadyException(String message) {
        super(message);
    }

    public CustomerAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }
}
