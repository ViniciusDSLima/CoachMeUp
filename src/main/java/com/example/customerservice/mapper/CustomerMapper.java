package com.example.customerservice.mapper;

import com.example.customerservice.DTO.CustomerDTO;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.request.customer.CustomerRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    Customer toCustomer(CustomerRegisterRequest customerRegisterRequest);

    CustomerDTO toCustomerDto(Customer customer);
}
