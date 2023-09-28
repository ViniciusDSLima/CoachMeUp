package com.example.coachMeUp.validations.validacoes.customer;

import com.example.coachMeUp.exceptions.errors.LengthException;
import com.example.coachMeUp.request.customer.CustomerRegisterRequest;
import com.example.coachMeUp.validations.Validation;
import org.springframework.stereotype.Component;

@Component
public class NameValidation  implements Validation {
    @Override
    public void valideCustomer(CustomerRegisterRequest request) {
        if(request.getName().length() < 3) throw new LengthException("The minimum length for the name is 3 characters");

        if(request.getName().length() > 255) throw new LengthException("The maximum length for the name is 255 characters");
    }
}
