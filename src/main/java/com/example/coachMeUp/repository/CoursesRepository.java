package com.example.coachMeUp.repository;

import com.example.coachMeUp.domain.entities.Category;
import com.example.coachMeUp.domain.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, String> {
    Optional<Courses> findByName(String name);

    Optional<List<Courses>> findByCategory(Category category);

    Optional<List<Courses>> findByPrice(BigDecimal price);
}