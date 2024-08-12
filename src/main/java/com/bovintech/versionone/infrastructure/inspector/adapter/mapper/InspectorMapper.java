package com.bovintech.versionone.infrastructure.inspector.adapter.mapper;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.infrastructure.certification.adapter.mapper.CertificationMapper;
import com.bovintech.versionone.infrastructure.company.adapter.mapper.CompanyMapper;
import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import com.bovintech.versionone.infrastructure.season.adapter.mapper.SeasonMapper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,uses = {CertificationMapper.class})
@Component
public interface InspectorMapper {

    InspectorDTO toDomain(InspectorEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    InspectorEntity toDbo(InspectorDTO domain);
}
