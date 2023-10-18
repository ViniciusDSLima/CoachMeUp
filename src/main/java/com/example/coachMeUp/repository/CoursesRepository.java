package com.example.coachMeUp.repository;

import com.example.coachMeUp.domain.entities.Category;
import com.example.coachMeUp.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Course, String> {
    Optional<Course> findByName(String name);

    Optional<List<Course>> findByCategory(Category category);
}
