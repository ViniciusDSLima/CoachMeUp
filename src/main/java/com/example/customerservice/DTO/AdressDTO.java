package com.example.customerservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdressDTO {
    private String morada;
    private long codigoPostal;
    private String porta;
    private String freguesia;
    private String concelho;
    private String distrito;
    private String localidade;
}
