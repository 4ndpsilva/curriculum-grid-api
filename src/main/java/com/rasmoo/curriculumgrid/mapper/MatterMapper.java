package com.rasmoo.curriculumgrid.mapper;

import com.rasmoo.curriculumgrid.dto.MatterDTO;
import com.rasmoo.curriculumgrid.entity.Matter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatterMapper {
    Matter map(MatterDTO dto);

    MatterDTO map(Matter entity);

    List<MatterDTO> map(List<Matter> entities);
}