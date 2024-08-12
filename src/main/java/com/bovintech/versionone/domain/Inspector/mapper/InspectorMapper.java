package com.bovintech.versionone.domain.Inspector.mapper;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorUpdateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InspectorMapper {
    InspectorMapper INSTANCE = Mappers.getMapper(InspectorMapper.class);

    InspectorShow toShow(InspectorDTO dto);

    @Mapping(target = "username", ignore = true)
    @Mapping(target = "certifications", ignore = true)
    void toUpdateFromDto(InspectorUpdateDTO updateDto, @MappingTarget InspectorDTO dto);
}
