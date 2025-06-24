package com.bovintech.versionone.domain.company.mapper;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.company.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {CertificationMapper.class})
public interface CompanyShowMapper {
    CompanyShowMapper INSTANCE = Mappers.getMapper(CompanyShowMapper.class);

    CompanyShowDTO toShow (CompanyDTO dto);

    @Mapping(target = "certificates", source = "certifications")
    CompanyWithCertificatesShowDTO toShowWithCertificates (CompanyDTO dto);

    void toUpdateFromDto(CompanyUpdateDTO updateDTO, @MappingTarget CompanyDTO dto);

    default List<CompanyCertificateDTO> mapCertificates(List<CertificationDTO> certifications) {
        if (certifications == null) {
            return null;
        }
        return certifications.stream()
                .map(CertificationMapper.INSTANCE::toShowFormat)
                .map(cert -> {
                    CompanyCertificateDTO dto = new CompanyCertificateDTO();
                    dto.setConsecutive(cert.getConsecutive());
                    dto.setClientConsecutive(cert.getClientConsecutive());
                    dto.setCiiu(cert.getCiu());
                    dto.setAddress(cert.getAddress());
                    dto.setId(cert.getId());
                    dto.setDate(cert.getDate());
                    dto.setValidateBy(cert.getValidateBy());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
