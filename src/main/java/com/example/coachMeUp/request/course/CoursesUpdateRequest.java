package com.example.coachMeUp.request.course;

import com.example.coachMeUp.domain.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesUpdateRequest {

    private String name;
    private BigDecimal price;
    private Category category;
}
