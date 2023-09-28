package com.example.coachMeUp.DTO;

import com.example.coachMeUp.domain.address.Address;
import com.example.coachMeUp.enums.Flat;
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
