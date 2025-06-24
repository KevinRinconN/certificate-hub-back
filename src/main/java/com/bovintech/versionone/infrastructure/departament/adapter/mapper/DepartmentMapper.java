package com.bovintech.versionone.infrastructure.departament.adapter.mapper;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.infrastructure.departament.adapter.model.entity.DepartamentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DepartmentMapper {
    DepartamentDTO toDomain (DepartamentEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    DepartamentEntity toDbo (DepartamentDTO dto);
}
