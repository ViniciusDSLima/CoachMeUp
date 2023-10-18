package com.example.coachMeUp.service;

import com.example.coachMeUp.DTO.CoursesDTO;
import com.example.coachMeUp.domain.entities.Category;
import com.example.coachMeUp.domain.entities.Course;
import com.example.coachMeUp.exceptions.errors.ObjectNotFoundException;
import com.example.coachMeUp.exceptions.errors.UndefinedName;
import com.example.coachMeUp.mapper.CoursesMapper;
import com.example.coachMeUp.repository.CoursesRepository;
import com.example.coachMeUp.request.course.CoursesRegisterRequest;
import com.example.coachMeUp.request.course.CoursesUpdateRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesRepository coursesRepository;

    @Transactional
    public CoursesDTO save(@Valid CoursesRegisterRequest request){
        Course course = coursesRepository.save(CoursesMapper.INSTANCE.toCustomer(request));

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    @Transactional
    public CoursesDTO updateCourse(@NotBlank String id, CoursesUpdateRequest request) {
        Course course = coursesRepository.getReferenceById(id);
        course.updateInfo(request);
        
        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public CoursesDTO findByName(@Min(3) String name){
        Course course = coursesRepository.findByName(name)
                .orElseThrow(() -> new UndefinedName("Curso nao encontrado."));

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public List<CoursesDTO> findByCategory(@Valid Category category){
        List<Course> cours = coursesRepository.findByCategory(category)
                .orElseThrow(() -> new ObjectNotFoundException("Nao ha cusos cadastrados com essa categoria."));

        return CoursesMapper.INSTANCE.toCoursesDTO(cours);
    }


    public void delete(@NotBlank String id) {
        var courseExists = coursesRepository.findById(id);

        if(courseExists.isEmpty()){
            throw new ObjectNotFoundException("Curso nao encontrado na base de dados");
        }

        coursesRepository.deleteById(id);
    }
}
