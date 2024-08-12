package com.bovintech.versionone.application.company.query;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.service.CompanySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanySearchHandler {
    private final CompanySearchService companySearchService;

    public Page<CompanyDTO> execute(CompanySearchParams companySearchParams){
        return companySearchService.execute(companySearchParams);
    }
}
