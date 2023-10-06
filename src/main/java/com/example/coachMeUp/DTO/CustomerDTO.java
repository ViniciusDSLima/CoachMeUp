package com.example.coachMeUp.DTO;

import com.example.coachMeUp.domain.address.Address;
import com.example.coachMeUp.domain.entities.Phone;
import com.example.coachMeUp.enums.Flat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;
    private List<Phone> phone;
    private Address address;
    private Flat flat;
}
