package com.bovintech.versionone.domain.company.usecases;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyBadRequest;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CompanyCreateUseCase {
    private final ICompanyRepository iCompanyRepository;

    public CompanyDTO execute (CompanyDTO companyDTO){
        Optional<CompanyDTO> existingCompany = iCompanyRepository.findByNit(companyDTO.getNit());

        if (existingCompany.isPresent()) {
            throw new CompanyBadRequest(CompanyErrorCatalog.COMPANY_BAD_REQUEST,"Empresa con el NIT " + companyDTO.getNit() + " ya existe.");
        }

        Optional<CompanyDTO> existingNameCompany = iCompanyRepository.findByName(companyDTO.getName());
        if (existingNameCompany.isPresent()) {
            throw new CompanyBadRequest(CompanyErrorCatalog.COMPANY_BAD_REQUEST,"Empresa con la razon social " + companyDTO.getName() + " ya existe.");
        }

        return iCompanyRepository.save(companyDTO);
    }
}
