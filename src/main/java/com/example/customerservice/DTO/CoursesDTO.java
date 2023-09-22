package com.example.customerservice.DTO;

import com.example.customerservice.domain.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDTO {
    private String name;
    private Category category;
    private BigDecimal price;
}
