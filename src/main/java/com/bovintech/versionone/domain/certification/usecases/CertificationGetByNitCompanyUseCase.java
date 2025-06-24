package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CertificationGetByNitCompanyUseCase {
    private final CompanyFindByNitService companyFindByNitService;

    public List<CertificationDTO> execute (String nit) {
        CompanyDTO companyDTO = companyFindByNitService.execute(nit);
        return companyDTO.getCertifications();
    }
}
