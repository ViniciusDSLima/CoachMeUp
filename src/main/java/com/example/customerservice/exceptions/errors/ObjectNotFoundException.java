package com.example.customerservice.exceptions.errors;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.aop.ThrowsAdvice;

@AllArgsConstructor
@NoArgsConstructor
public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public ObjectNotFoundException(String message){
        super(message);
    }
}
