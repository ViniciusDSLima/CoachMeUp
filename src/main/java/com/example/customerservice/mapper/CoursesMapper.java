package com.example.customerservice.mapper;

import com.example.customerservice.DTO.CoursesDTO;
import com.example.customerservice.domain.models.Courses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoursesMapper {

    CoursesMapper INSTANCE = Mappers.getMapper(CoursesMapper.class);


    CoursesDTO toCoursesDTO(Courses course);
}
