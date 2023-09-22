package com.example.customerservice.request.customer;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAddress {
    private String street;
    private int postalCode;
    private String houseNumber;
    private String parish;
    private String municipalities;
    private String district;
    private String complement;
}
