package com.bovintech.versionone.domain.company.usecases;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.CompanyWithCertificatesShowDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyGetByIdUseCase {
    private final ICompanyRepository iCompanyRepository;

    public CompanyDTO execute (Long id){
        return iCompanyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException(CompanyErrorCatalog.COMPANY_NOT_FOUND,
                "Empresa con el id " + id + " no fue encontrada"));
    }
}
