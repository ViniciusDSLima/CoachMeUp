package com.example.customerservice.service;

import com.example.customerservice.DTO.CoursesDTO;
import com.example.customerservice.domain.models.Category;
import com.example.customerservice.domain.models.Courses;
import com.example.customerservice.exceptions.errors.ObjectNotFoundException;
import com.example.customerservice.exceptions.errors.UndefinedName;
import com.example.customerservice.mapper.CoursesMapper;
import com.example.customerservice.repository.CoursesRepository;
import com.example.customerservice.request.course.CoursesUpdateRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesRepository coursesRepository;

    @Transactional
    public CoursesDTO save(Courses courses){
        Courses course = coursesRepository.save(courses);

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    @Transactional
    public CoursesDTO updateCourse(@NotBlank String id, CoursesUpdateRequest request) {
        Courses course = coursesRepository.getReferenceById(id);
        course.updateInfo(request);
        
        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public CoursesDTO findByName(String name){
        Courses course = coursesRepository.findByName(name)
                .orElseThrow(() -> new UndefinedName("Curso nao encontrado."));

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public List<CoursesDTO> findByCategory(@Valid Category category){
        List<Courses> courses = coursesRepository.findByCategory(category)
                .orElseThrow(() -> new ObjectNotFoundException("Nao ha cusos cadastrados com essa categoria."));

        return CoursesMapper.INSTANCE.toCoursesDTO(courses);
    }


    public void delete(@NotBlank String id) {
        var courseExists = coursesRepository.findById(id);

        if(courseExists.isEmpty()){
            throw new ObjectNotFoundException("Curso nao encontrado na base de dados");
        }

        coursesRepository.deleteById(id);
    }
}
