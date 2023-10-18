package com.example.coachMeUp.request.packages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageRegisterRequest {

    private String name;

    private BigDecimal price;

    private int quantity;
}