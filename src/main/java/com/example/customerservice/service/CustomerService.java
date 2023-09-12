package com.example.customerservice.service;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.exceptions.errors.LengthException;
import com.example.customerservice.exceptions.errors.ObjectNotFoundException;
import com.example.customerservice.mapper.CustomerMapper;
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

        if(customerRegisterRequest.getName().length() < 3) throw new LengthException("The minimum length for the name is 3 characters");

        if(customerRegisterRequest.getName().length() > 255) throw new LengthException("The maximum length for the name is 255 characters");

        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customerRegisterRequest));

        return CustomerMapper.INSTANCE.toCustomerDto(customer);
    }

    public CustomerDTO findById(String id){
        return CustomerMapper.INSTANCE.toCustomerDto(customerRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Customer Not Found")));
    }
}
