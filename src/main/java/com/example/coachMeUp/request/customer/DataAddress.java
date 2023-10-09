package com.example.coachMeUp.request.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAddress {
    private String morada;
    private String codigoPostal;
    private String porta;
    private String freguesia;
    private String concelho;
    private String distrito;
    private String localidade;
}
