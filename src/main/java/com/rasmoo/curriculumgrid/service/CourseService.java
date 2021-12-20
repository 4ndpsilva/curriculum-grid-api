package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Course;
import com.rasmoo.curriculumgrid.repository.CourseRepository;
import com.rasmoo.curriculumgrid.repository.spec.CourseSpec;
import com.rasmoo.curriculumgrid.service.core.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CourseService extends AbstractCrudService<Course, Long> {
    private final CourseSpec spec;

    @Autowired
    public CourseService(final CourseRepository repository, final CourseSpec spec) {
        super(repository, Course.class);
        this.spec = spec;
    }

    @Override
    public void validate() {}

    @Override
    public Specification<Course> createFilter(final Map<String, Object> params) {
        spec.setParams(params);
        return spec;
    }
}