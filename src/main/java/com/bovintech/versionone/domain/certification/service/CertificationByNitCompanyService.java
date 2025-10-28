package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByNitCompanyUseCase;
import com.bovintech.versionone.domain.certification.usecases.QrTokenGenerateUseCase;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CertificationByNitCompanyService {
    private final CertificationGetByNitCompanyUseCase certificationGetByNitCompanyUseCase;
    private final QrTokenGenerateUseCase qrTokenGenerateUseCase;
    private final DepartamentGetUseCase departamentGetUseCase;

    public List<CertificateDTO> execute (String nit) {
        List<CertificationDTO> dtoList = certificationGetByNitCompanyUseCase.execute(nit);

        // Filtrar para mantener solo el certificado más reciente por dirección
        Map<String, CertificationDTO> filteredMap = dtoList.stream()
                .collect(Collectors.toMap(
                        CertificationDTO::getAddress, // Agrupar por dirección
                        cert -> cert, // Usar el certificado como valor
                        (existing, replacement) -> existing.getDate().isAfter(replacement.getDate()) ? existing : replacement // Seleccionar el más reciente
                ));
        DepartamentDTO department = departamentGetUseCase.execute();
        return filteredMap.values().stream()
                .map(certification -> {
                    CertificateDTO certificate = CertificationMapper.INSTANCE.toShow(certification);
                    certificate.setQrToken(qrTokenGenerateUseCase.execute(String.valueOf(certificate.getId())));
                    certificate.setDepartment(department);
                    return certificate;
                })
                .toList();
    }
}
