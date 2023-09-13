package com.example.customerservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAddress {
    private String street;
    private long postalCode;
    private int houseNumber;
    private String parish;
    private String municipalities;
    private String district;
    private String complement;
}
