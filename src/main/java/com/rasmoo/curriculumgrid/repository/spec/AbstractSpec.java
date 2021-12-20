package com.rasmoo.curriculumgrid.repository.spec;

import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public abstract class AbstractSpec<T> implements Specification<T> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        if(params.get("id") != null && !params.get("id").toString().isBlank()){
            Long id = Long.parseLong(params.get("id").toString());
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}