package com.example.customerservice.repository;

import com.example.customerservice.domain.models.Category;
import com.example.customerservice.domain.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, String> {
    Optional<Courses> findByName(String name);

    Optional<List<Courses>> findByCategory(Category category);
}
