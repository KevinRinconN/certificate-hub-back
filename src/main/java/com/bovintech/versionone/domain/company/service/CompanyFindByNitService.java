package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyFindByNitService {
    private final ICompanyRepository iCompanyRepository;

    public CompanyDTO execute (String nit) {
        return iCompanyRepository.findByNit(nit)
                .orElseThrow(()-> new CompanyNotFoundException(CompanyErrorCatalog.COMPANY_NOT_FOUND,
                        "Empresa con el NIT " + nit + " no fue encontrada"));
    }
}
