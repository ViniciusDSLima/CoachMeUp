package com.example.customerservice.validations.validacoes.customer;

import com.example.customerservice.exceptions.errors.LengthException;
import com.example.customerservice.request.customer.CustomerRegisterRequest;
import com.example.customerservice.validations.Validation;
import org.springframework.stereotype.Component;

@Component
public class NameValidation  implements Validation {
    @Override
    public void valideCustomer(CustomerRegisterRequest request) {
        if(request.getName().length() < 3) throw new LengthException("The minimum length for the name is 3 characters");

        if(request.getName().length() > 255) throw new LengthException("The maximum length for the name is 255 characters");
    }
}
