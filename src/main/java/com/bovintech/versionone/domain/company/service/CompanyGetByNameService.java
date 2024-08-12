package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyGetByNameService {
    private final ICompanyRepository iCompanyRepository;

    public CompanyDTO execute (String businessName){
        return iCompanyRepository.findByName(businessName)
                .orElseThrow(()-> new CompanyNotFoundException(CompanyErrorCatalog.COMPANY_NOT_FOUND,
                        "Empresa con la razon social " + businessName + " no fue encontrada"));
    }
}
