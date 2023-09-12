package com.example.customerservice.DTO;

import com.example.customerservice.domain.address.Address;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;
    private String NIF;
    private String phone;
    @Embedded
    private Address address;
    private Flat flat;

}
