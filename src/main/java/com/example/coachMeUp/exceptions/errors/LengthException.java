package com.example.coachMeUp.exceptions.errors;

public class LengthException extends RuntimeException{

    public LengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public LengthException(String message) {
        super(message);
    }
}
