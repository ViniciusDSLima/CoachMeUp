package com.example.coachMeUp.mapper;

import com.example.coachMeUp.DTO.CoursesDTO;
import com.example.coachMeUp.domain.entities.Courses;
import com.example.coachMeUp.request.CoursesRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CoursesMapper {

    CoursesMapper INSTANCE = Mappers.getMapper(CoursesMapper.class);


    CoursesDTO toCourseDTO(Courses courses);

    List<CoursesDTO> toCoursesDTO(List<Courses> course);

    Courses toCustomer(CoursesRegisterRequest request);
}
