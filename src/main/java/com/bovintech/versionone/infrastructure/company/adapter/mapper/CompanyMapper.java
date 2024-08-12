package com.bovintech.versionone.infrastructure.company.adapter.mapper;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.infrastructure.certification.adapter.mapper.CertificationMapper;
import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import com.bovintech.versionone.infrastructure.company.adapter.model.entity.CompanyEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CertificationMapper.class})
@Component
public interface CompanyMapper {

    @Mapping(target = "certifications.company", ignore = true)
    CompanyDTO toDomain(CompanyEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    @Mapping(target = "certifications.company", ignore = true)
    CompanyEntity toDbo(CompanyDTO domain);
}
