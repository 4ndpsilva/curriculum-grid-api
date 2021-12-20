package com.rasmoo.curriculumgrid.mapper;

import com.rasmoo.curriculumgrid.dto.CourseDTO;
import com.rasmoo.curriculumgrid.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends GenericMapper<Course, CourseDTO> { }