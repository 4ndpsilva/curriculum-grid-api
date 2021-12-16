package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.repository.MatterRepository;
import com.rasmoo.curriculumgrid.repository.spec.CommonSpec;
import com.rasmoo.curriculumgrid.service.core.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MatterService extends AbstractCrudService<Matter, Long> {
    private CommonSpec<Matter> commonSpec;

    @Autowired
    public MatterService(final MatterRepository repository, CommonSpec<Matter> commonSpec) {
        super(repository, Matter.class, commonSpec);
        this.commonSpec = commonSpec;
    }

    @Override
    public void validate() {}

    @Override
    public Specification<Matter> createFilter(final Map<String, Object> params) {
        Specification<Matter> spec = Specification.where(null);

        if(params.get("code") != null && !params.get("code").toString().isBlank()){
            spec = spec.and(commonSpec.equal("code", params.get("code")));
        }
        if(params.get("name") != null && !params.get("name").toString().isBlank()){
            spec = spec.and(commonSpec.like("name", params.get("name")));
        }

        return spec;
    }
}