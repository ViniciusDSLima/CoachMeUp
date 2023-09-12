package com.example.customerservice.request;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.enums.CustomerRole;
import com.example.customerservice.enums.Flat;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequest {
    private String name;
    private String email;
    private String password;
    private long NIF;
    private long phone;
    private Address address;
    private Flat flat;
    private CustomerRole role;

}
