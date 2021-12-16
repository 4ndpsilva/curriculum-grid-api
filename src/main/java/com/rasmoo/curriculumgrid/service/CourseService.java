package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Course;
import com.rasmoo.curriculumgrid.repository.CourseRepository;
import com.rasmoo.curriculumgrid.repository.spec.CommonSpec;
import com.rasmoo.curriculumgrid.service.core.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CourseService extends AbstractCrudService<Course, Long> {

    @Autowired
    public CourseService(final CourseRepository repository, CommonSpec<Course> commonSpec) {
        super(repository, Course.class, commonSpec);
    }

    @Override
    public void validate() {

    }

    @Override
    public Specification<Course> createFilter(Map<String, Object> params) {
        return null;
    }
}