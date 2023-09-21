package com.example.customerservice.validations.validacoes;

import com.example.customerservice.exceptions.errors.CustomerAlreadyException;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.validations.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements Validation {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void validate(CustomerRegisterRequest request) {
        var customerExists = customerRepository.findByEmail(request.getEmail());

        if(customerExists.isPresent()){
            throw new CustomerAlreadyException("cliente ja cadastrado");
        }
    }
}
