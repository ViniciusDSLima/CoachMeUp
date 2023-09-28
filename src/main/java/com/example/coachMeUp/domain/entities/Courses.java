package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.request.course.CoursesUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "courses", uniqueConstraints =
            @UniqueConstraint(columnNames = "id"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal price;

    public void updateInfo(CoursesUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getPrice() != null) this.price = request.getPrice();
        if(request.getCategory() != null) this.category = request.getCategory();
    }
}
