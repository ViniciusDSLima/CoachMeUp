package com.example.customerservice.DTO;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.enums.Flat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;
    private long NIF;
    private String phone;
    private Address address;
    private Flat flat;

}
