package com.example.coachMeUp.mapper;

import com.example.coachMeUp.DTO.CustomerDTO;
import com.example.coachMeUp.domain.entities.Customer;
import com.example.coachMeUp.request.customer.CustomerRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    Customer toCustomer(CustomerRegisterRequest customerRegisterRequest);

    CustomerDTO toCustomerDto(Customer customer);
}
