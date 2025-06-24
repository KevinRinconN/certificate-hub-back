package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.mapper.CompanyShowMapper;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.CompanyShowDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.usecases.CompanySearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class CompanySearchService {
    private final CompanySearchUseCase companySearchUseCase;

    public Page<CompanyShowDTO> execute (CompanySearchParams companySearchParams){
        Page<CompanyDTO> dto = companySearchUseCase.execute(companySearchParams);
        return dto.map(CompanyShowMapper.INSTANCE::toShow);
    }

}
