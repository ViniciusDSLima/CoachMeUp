package com.example.coachMeUp.DTO;

import com.example.coachMeUp.domain.entities.Category;
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
