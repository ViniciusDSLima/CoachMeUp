package com.example.coachMeUp.mapper;

import com.example.coachMeUp.DTO.CoursesDTO;
import com.example.coachMeUp.domain.entities.Course;
import com.example.coachMeUp.request.course.CoursesRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CoursesMapper {

    CoursesMapper INSTANCE = Mappers.getMapper(CoursesMapper.class);


    CoursesDTO toCourseDTO(Course course);

    List<CoursesDTO> toCoursesDTO(List<Course> course);

    Course toCustomer(CoursesRegisterRequest request);
}
