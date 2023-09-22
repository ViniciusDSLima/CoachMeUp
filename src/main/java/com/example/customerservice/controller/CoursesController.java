package com.example.customerservice.controller;

import com.example.customerservice.domain.models.Courses;
import com.example.customerservice.service.CoursesService;
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
    public ResponseEntity save(@RequestBody Courses courses){
        return ResponseEntity.status(HttpStatus.CREATED).body(coursesService.save(courses));
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(coursesService.findByName(name));
    }
}
