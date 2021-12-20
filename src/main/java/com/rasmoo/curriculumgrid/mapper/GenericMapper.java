package com.rasmoo.curriculumgrid.mapper;

import java.util.List;

public interface GenericMapper<T, D> {
    T mapToEntity(D dto);

    D mapToDTO(T entity);

    List<D> mapToListDTO(List<T> entities);
}