package com.example.customerservice.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    private String street;
    private long code;
    private int number;
    private String parish;
    private String municipalities;
    private String district;
    private String complement;

}
