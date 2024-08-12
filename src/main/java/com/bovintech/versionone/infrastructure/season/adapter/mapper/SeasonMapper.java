package com.bovintech.versionone.infrastructure.season.adapter.mapper;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.infrastructure.certification.adapter.mapper.CertificationMapper;
import com.bovintech.versionone.infrastructure.season.adapter.model.entity.SeasonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CertificationMapper.class})
@Component
public interface SeasonMapper {

    @Mapping(target = "certifications.season", ignore = true)
    SeasonDTO toDomain(SeasonEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    @Mapping(target = "certifications.season", ignore = true)
    SeasonEntity toDbo(SeasonDTO domain);
}