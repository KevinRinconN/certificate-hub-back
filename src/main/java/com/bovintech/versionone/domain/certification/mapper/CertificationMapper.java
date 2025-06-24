package com.bovintech.versionone.domain.certification.mapper;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CertificationMapper {

    CertificationMapper INSTANCE = Mappers.getMapper( CertificationMapper.class );

    @Mapping(target = "valid", expression = "java(certificationDTO.isActive())")
    @Mapping(target = "formattedConsecutive", expression = "java(certificationDTO.getFormatConsecutive())")
    CertificateDTO toShow(CertificationDTO certificationDTO);

    @Mapping(target = "formattedConsecutive", expression = "java(certificationDTO.getFormatConsecutive())")
    CertificateDTO toShowFormat(CertificationDTO certificationDTO);

    @Mapping(target = "inspector.username", source = "inspectorId")
    @Mapping(target = "season.id", source = "seasonId")
    void toUpdateFromDto(CertificationUpdateDTO dto,  @MappingTarget CertificationDTO entity);
}
