package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyBadRequest;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
public class CompanyCreateService {
    private final ICompanyRepository iCompanyRepository;

    public CompanyDTO execute (CompanyDTO companyDTO){
        Optional<CompanyDTO> existingCompany = iCompanyRepository.findByNit(companyDTO.getNit());

        if (existingCompany.isPresent()) {
            throw new CompanyBadRequest(CompanyErrorCatalog.COMPANY_BAD_REQUEST,"Company with NIT " + companyDTO.getNit() + " already exists.");
        }

        return iCompanyRepository.save(companyDTO);
    }
}
