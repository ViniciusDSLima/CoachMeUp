package com.example.coachMeUp.domain.entities;

import com.example.coachMeUp.request.course.CoursesUpdateRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonBackReference
    @ManyToMany(mappedBy = "courses")
    private List<Package> packages;

    @JsonBackReference
    @ManyToMany(mappedBy = "courses")
    private List<Customer> customers;

    public void updateInfo(CoursesUpdateRequest request) {
        if(request.getName() != null) this.name = request.getName();
        if(request.getCategory() != null) this.category = request.getCategory();
    }
}
