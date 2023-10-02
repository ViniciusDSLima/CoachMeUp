package com.example.coachMeUp.service;

import com.example.coachMeUp.DTO.CoursesDTO;
import com.example.coachMeUp.domain.entities.Category;
import com.example.coachMeUp.domain.entities.Courses;
import com.example.coachMeUp.exceptions.errors.ObjectNotFoundException;
import com.example.coachMeUp.exceptions.errors.UndefinedName;
import com.example.coachMeUp.mapper.CoursesMapper;
import com.example.coachMeUp.repository.CoursesRepository;
import com.example.coachMeUp.request.CoursesRegisterRequest;
import com.example.coachMeUp.request.course.CoursesUpdateRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesRepository coursesRepository;

    @Transactional
    public CoursesDTO save(@Valid CoursesRegisterRequest request){
        Courses course = coursesRepository.save(CoursesMapper.INSTANCE.toCustomer(request));

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    @Transactional
    public CoursesDTO updateCourse(@NotBlank String id, CoursesUpdateRequest request) {
        Courses course = coursesRepository.getReferenceById(id);
        course.updateInfo(request);
        
        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public CoursesDTO findByName(@Min(3) String name){
        Courses course = coursesRepository.findByName(name)
                .orElseThrow(() -> new UndefinedName("Curso nao encontrado."));

        return CoursesMapper.INSTANCE.toCourseDTO(course);
    }

    public List<CoursesDTO> findByCategory(@Valid Category category){
        List<Courses> courses = coursesRepository.findByCategory(category)
                .orElseThrow(() -> new ObjectNotFoundException("Nao ha cusos cadastrados com essa categoria."));

        return CoursesMapper.INSTANCE.toCoursesDTO(courses);
    }

    public List<CoursesDTO> findByPrice(@Positive BigDecimal price){
        List<Courses> courses = coursesRepository.findByPrice(price)
                .orElseThrow(() -> new ObjectNotFoundException("Nao ha cursos com essa faixa de preco."));

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
