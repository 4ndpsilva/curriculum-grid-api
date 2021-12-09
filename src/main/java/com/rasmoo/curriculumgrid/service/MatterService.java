package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.exception.BusinessException;
import com.rasmoo.curriculumgrid.repository.MatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatterService implements CrudService<Matter, Long>{
    private final MatterRepository repository;

    public Matter save(final Matter entity){
        return repository.save(entity);
    }

    public Matter update(final Long id, final Matter entity){
        entity.setId(id);
        return repository.save(entity);
    }

    public Matter findById(final Long id){
        Optional<Matter> opMatter = repository.findById(id);

        if(opMatter.isPresent()){
            return opMatter.get();
        }

        throw new BusinessException("API-001");
    }

    public List<Matter> findAll(){
        return repository.findAll();
    }

    public void delete(final Long id){
        if(!repository.existsById(id)){
            throw new BusinessException("API-001");
        }

        repository.deleteById(id);
    }
}