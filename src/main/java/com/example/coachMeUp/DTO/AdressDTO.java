package com.example.coachMeUp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdressDTO {
    private String morada;
    private String codigoPostal;
    private String porta;
    private String freguesia;
    private String concelho;
    private String distrito;
    private String localidade;
}
