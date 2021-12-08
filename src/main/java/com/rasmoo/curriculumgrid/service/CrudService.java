package com.rasmoo.curriculumgrid.service;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T, ID extends Serializable> {
    T save(T entity);

    T update(ID id, T entity);

    T findById(ID id);

    void delete(ID id);

    List<T> findAll();
}