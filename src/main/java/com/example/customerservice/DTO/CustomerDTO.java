package com.example.customerservice.DTO;

import com.example.customerservice.domain.address.Address;
import com.example.customerservice.domain.models.Customer;
import com.example.customerservice.enums.Flat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime created_at = LocalDateTime.now();
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updated_at = LocalDateTime.now();
}
