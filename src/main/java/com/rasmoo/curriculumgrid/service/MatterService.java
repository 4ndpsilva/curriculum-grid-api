package com.rasmoo.curriculumgrid.service;

import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.repository.MatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada"));
    }

    public List<Matter> findAll(){
        return repository.findAll();
    }

    public void delete(final Long id){
        repository.deleteById(id);
    }
}