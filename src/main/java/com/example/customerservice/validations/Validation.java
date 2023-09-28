package com.example.customerservice.validations;

import com.example.customerservice.request.customer.CustomerRegisterRequest;

public interface Validation {
    void valideCustomer(CustomerRegisterRequest request);

}
