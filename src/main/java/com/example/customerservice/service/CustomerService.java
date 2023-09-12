package com.example.customerservice.service;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.exceptions.errors.ObjectNotFoundException;
import com.example.customerservice.mapper.CustomerMapper;
import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.request.CustomerUpdateRequest;
import com.example.customerservice.validations.ValidationsName;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO save(CustomerRegisterRequest customerRegisterRequest){

        ValidationsName.valideRegister(customerRegisterRequest);

        Customer customer = customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customerRegisterRequest));

        return CustomerMapper.INSTANCE.toCustomerDto(customer);
    }

    public CustomerDTO findById(String id){
        return CustomerMapper.INSTANCE.toCustomerDto(customerRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Customer Not Found")));
    }

    @Transactional
    public CustomerDTO update(CustomerUpdateRequest customerUpdateRequest){

        ValidationsName.valideUpdate(customerUpdateRequest);

        Customer customer = customerRepository.save(new Customer(customerUpdateRequest));

        return CustomerMapper.INSTANCE.toCustomerDto(customer);
    }
}
