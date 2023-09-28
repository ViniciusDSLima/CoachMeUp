package com.example.coachMeUp.validations.validacoes.customer;

import com.example.coachMeUp.exceptions.errors.CustomerAlreadyException;
import com.example.coachMeUp.repository.CustomerRepository;
import com.example.coachMeUp.request.customer.CustomerRegisterRequest;
import com.example.coachMeUp.validations.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NifValidation implements Validation {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void valideCustomer(CustomerRegisterRequest request) {
        var customerExists = customerRepository.findByNIF(request.getNIF());

        if(customerExists.isPresent()){
            throw new CustomerAlreadyException("Cliente Com o NIF ja cadastrado.");
        }
    }
}
