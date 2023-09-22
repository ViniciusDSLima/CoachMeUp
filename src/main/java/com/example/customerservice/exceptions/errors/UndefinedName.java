package com.example.customerservice.exceptions.errors;

public class UndefinedName extends RuntimeException {
    public UndefinedName(String message) {
        super(message);
    }

    public UndefinedName(String message, Throwable cause) {
        super(message, cause);
    }
}
