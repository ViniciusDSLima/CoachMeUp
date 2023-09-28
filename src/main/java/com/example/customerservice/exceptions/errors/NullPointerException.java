package com.example.customerservice.exceptions.errors;

import org.springframework.data.jpa.repository.JpaRepository;

public class NullPointerException extends RuntimeException {

    public NullPointerException(String message) {
        super(message);
    }

    public NullPointerException(String message, Throwable cause) {
        super(message, cause);
    }
}
