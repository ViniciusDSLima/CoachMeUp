package com.example.coachMeUp.exceptions.errors;

public class EmailNotFound extends RuntimeException {
    public EmailNotFound(String email) {
        super(email);
    }

    public EmailNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
