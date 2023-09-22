package com.example.customerservice.exceptions.errors;

public class UndefinedCategory extends RuntimeException {
    public UndefinedCategory(String message) {
        super(message);
    }

    public UndefinedCategory(String message, Throwable cause) {
        super(message, cause);
    }
}
