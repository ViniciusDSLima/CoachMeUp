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

    public void updateInfo(Address address) {
        this.street = address.street;
        this.number = address.number;
        this.parish = address.parish;
        this.municipalities = address.municipalities;
        this.district = address.district;
        this.complement = address.complement;
    }
}
