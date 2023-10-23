package com.example.coachMeUp.exceptions.errors;

public class FieldsExcpetions extends RuntimeException {
    public FieldsExcpetions(String message) {
        super(message);
    }

    public FieldsExcpetions(String message, Throwable cause) {
        super(message, cause);
    }
}
