package com.example.coachMeUp.request;

import com.example.coachMeUp.domain.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesRegisterRequest {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Category category;
}
