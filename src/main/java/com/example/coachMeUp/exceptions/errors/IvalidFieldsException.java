package com.example.coachMeUp.exceptions.errors;

public class IvalidFieldsException extends RuntimeException {

    public IvalidFieldsException(String message) {
        super(message);
    }

    public IvalidFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}
