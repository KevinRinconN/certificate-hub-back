package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class CompanySearchService {
    private final ICompanyRepository iCompanyRepository;

    public Page<CompanyDTO> execute (CompanySearchParams companySearchParams){
        return iCompanyRepository.search(companySearchParams);
    }

}
