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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.customerservice.enums.MensagemCustomer.OBJETO_NAO_ENCONTRADO;

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
    public CustomerDTO update(@NotBlank String id,@Valid CustomerUpdateRequest customerUpdateRequest){

        var customer = customerRepository.findById(id);

        if(!customer.isPresent()){
            throw new ObjectNotFoundException(CUSTOMER_NAO_ENCONTRADO.getDescription());
        }
    }
}
