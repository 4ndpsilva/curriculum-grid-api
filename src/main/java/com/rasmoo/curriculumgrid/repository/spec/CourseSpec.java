package com.rasmoo.curriculumgrid.repository.spec;

import com.rasmoo.curriculumgrid.entity.Course;
import lombok.Setter;
import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Component
public class CourseSpec extends AbstractSpec<Course> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        Object name = params.get("name");

        if(name != null && !name.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("name")), "%"+name.toString().toLowerCase()+"%"));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}