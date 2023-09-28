package com.example.coachMeUp.request.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAddress {
    @NotBlank
    private String morada;
    @NotNull
    private String codigoPostal;
    private String porta;
    @NotBlank
    private String freguesia;
    @NotBlank
    private String concelho;
    @NotBlank
    private String distrito;
    @NotBlank
    private String localidade;
}
