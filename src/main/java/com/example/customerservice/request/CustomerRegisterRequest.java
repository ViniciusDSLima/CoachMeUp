package com.example.customerservice.request;

import com.example.customerservice.enums.CustomerRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequest {
    private String email;
    private String password;
    private CustomerRole role;
}
