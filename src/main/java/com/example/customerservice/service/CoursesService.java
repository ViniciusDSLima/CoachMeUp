package com.example.customerservice.service;

import com.example.customerservice.DTO.CoursesDTO;
import com.example.customerservice.domain.models.Courses;
import com.example.customerservice.exceptions.errors.UndefinedName;
import com.example.customerservice.mapper.CoursesMapper;
import com.example.customerservice.repository.CoursesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesRepository coursesRepository;

    public CoursesDTO findByName(String name){
        Courses course = coursesRepository.findByName(name)
                .orElseThrow(() -> new UndefinedName("Curso nao encontrado."));

        return CoursesMapper.INSTANCE.toCoursesDTO(course);
    }

    @Transactional
    public CoursesDTO save(Courses courses){
        Courses course = coursesRepository.save(courses);

        return CoursesMapper.INSTANCE.toCoursesDTO(course);
    }

}
