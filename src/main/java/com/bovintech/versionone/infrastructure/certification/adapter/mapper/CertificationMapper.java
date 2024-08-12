package com.bovintech.versionone.infrastructure.certification.adapter.mapper;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import com.bovintech.versionone.infrastructure.company.adapter.mapper.CompanyMapper;
import com.bovintech.versionone.infrastructure.inspector.adapter.mapper.InspectorMapper;
import com.bovintech.versionone.infrastructure.season.adapter.mapper.SeasonMapper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,uses = {SeasonMapper.class, InspectorMapper.class, CompanyMapper.class})
@Component
public interface CertificationMapper {
    @Mapping(target = "inspector.certifications", ignore = true)
    @Mapping(target = "season.certifications", ignore = true)
    @Mapping(target = "company.certifications", ignore = true)
    CertificationDTO toDomain(CertificationEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    @Mapping(target = "inspector.certifications", ignore = true)
    @Mapping(target = "season.certifications", ignore = true)
    @Mapping(target = "company.certifications", ignore = true)
    CertificationEntity toDbo(CertificationDTO domain);

    @Mapping(target = "inspector")
    @Mapping(target = "season")
    @Mapping(target = "company")
    CertificateDTO toCertificate(CertificationDTO certificationDTO);
}
