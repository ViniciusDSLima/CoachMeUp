package com.example.coachMeUp.controller;

import com.example.coachMeUp.domain.entities.Category;
import com.example.coachMeUp.request.course.CoursesRegisterRequest;
import com.example.coachMeUp.request.course.CoursesUpdateRequest;
import com.example.coachMeUp.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CoursesController {

    private CoursesService coursesService;

    @PostMapping("/register")
    public ResponseEntity save(@RequestBody CoursesRegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(coursesService.save(request));
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(coursesService.findByName(name));
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity findByCategory(@PathVariable("category") Category category){
        return ResponseEntity.status(HttpStatus.OK).body(coursesService.findByCategory(category));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable("id") String id, @RequestBody CoursesUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(coursesService.updateCourse(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable("id") String id){

        coursesService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
