package com.rasmoo.curriculumgrid.service.core;

import com.rasmoo.curriculumgrid.entity.BaseEntity;
import com.rasmoo.curriculumgrid.exception.ResourceNotFoundException;
import com.rasmoo.curriculumgrid.repository.core.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
public abstract class AbstractCrudService<T extends BaseEntity<ID>, ID extends Serializable> {
    private final BaseRepository<T, ID> repository;
    private final Class<T> entityClass;

    @Transactional
    public T save(final T entity) {
        validate();
        log.info("Iniciando operação Save");

        final T entityObj = BeanUtils.instantiateClass(entityClass);
        final T saved = save(entity, entityObj, "id");

        log.info("Operação Save finalizada");
        return saved;
    }

    @Transactional
    public T update(final ID id, final T updateEntity) {
        validate();
        log.info("Iniciando operação Update");

        final T entity = findById(id);
        final T updated = save(updateEntity, entity, "id");

        log.info("Operação Update finalizada");
        return updated;
    }

    private T save(final T oldEntity, final T newEntity, final String... ignoreProps) {
        BeanUtils.copyProperties(oldEntity, newEntity, ignoreProps);
        return repository.save(newEntity);
    }

    @Transactional
    public void delete(final ID id) {
        log.info("Starting delete entity operation");

        final T entity = findById(id);
        repository.deleteById(entity.getId());

        log.info("Finished delete operation");
    }

    public T findById(final ID id) {
        final Optional<T> opEntity = repository.findById(id);

        if (opEntity.isPresent()) {
            return opEntity.get();
        }

        throw new ResourceNotFoundException("API-001", id);
    }

    public List<T> find(Map<String, Object> params) {
        return repository.findAll(createFilter(params));
    }

    public abstract void validate();

    public abstract Specification<T> createFilter(final Map<String, Object> params);
}