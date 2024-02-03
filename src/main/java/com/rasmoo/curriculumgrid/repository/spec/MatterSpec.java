package com.rasmoo.curriculumgrid.repository.spec;

import com.rasmoo.curriculumgrid.entity.Matter;
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
public class MatterSpec extends AbstractSpec<Matter> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Matter> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        if(params.get("code") != null && !params.get("code").toString().isBlank()){
            predicates.add(builder.equal(root.get("code"), params.get("code").toString()));
        }
        if(params.get("name") != null && !params.get("name").toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("name")), "%"+params.get("name").toString().toLowerCase()+"%"));
        }

        params = null;
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}