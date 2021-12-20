package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.repository.MatterRepository;
import com.rasmoo.curriculumgrid.repository.spec.MatterSpec;
import com.rasmoo.curriculumgrid.service.core.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MatterService extends AbstractCrudService<Matter, Long> {
    private final MatterSpec spec;

    @Autowired
    public MatterService(final MatterRepository repository, final MatterSpec spec) {
        super(repository, Matter.class);
        this.spec = spec;
    }

    @Override
    public void validate() {}

    @Override
    public Specification<Matter> createFilter(final Map<String, Object> params) {
        spec.setParams(params);
        return spec;
    }
}