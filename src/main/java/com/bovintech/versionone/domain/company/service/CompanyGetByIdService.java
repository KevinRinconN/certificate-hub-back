package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.mapper.CompanyShowMapper;
import com.bovintech.versionone.domain.company.model.CompanyWithCertificatesShowDTO;
import com.bovintech.versionone.domain.company.usecases.CompanyGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyGetByIdService {
    private final CompanyGetByIdUseCase companyGetByIdUseCase;

    public CompanyWithCertificatesShowDTO execute (Long id){

        return CompanyShowMapper.INSTANCE.toShowWithCertificates(companyGetByIdUseCase.execute(id));
    }
}
