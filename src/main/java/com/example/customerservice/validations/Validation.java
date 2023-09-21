package com.example.customerservice.validations;

import com.example.customerservice.request.CustomerRegisterRequest;

public interface Validation {
    void validate(CustomerRegisterRequest request);
}
