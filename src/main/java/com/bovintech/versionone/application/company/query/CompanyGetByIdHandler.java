package com.bovintech.versionone.application.company.query;

import com.bovintech.versionone.domain.company.model.CompanyWithCertificatesShowDTO;
import com.bovintech.versionone.domain.company.service.CompanyGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyGetByIdHandler {
    private final CompanyGetByIdService companyGetByIdService;

    public CompanyWithCertificatesShowDTO execute (Long id){
        return companyGetByIdService.execute(id);
    }
}
