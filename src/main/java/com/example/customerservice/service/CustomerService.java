package com.example.customerservice.service;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.request.CustomerRegisterRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO save(CustomerRegisterRequest customerRegisterRequest){
        customerRepository.save(new Customer(customerRegisterRequest));
    }
}
