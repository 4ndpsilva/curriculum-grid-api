package com.rasmoo.curriculumgrid.mapper;

import com.rasmoo.curriculumgrid.dto.MatterDTO;
import com.rasmoo.curriculumgrid.entity.Matter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatterMapper extends GenericMapper<Matter, MatterDTO>{ }