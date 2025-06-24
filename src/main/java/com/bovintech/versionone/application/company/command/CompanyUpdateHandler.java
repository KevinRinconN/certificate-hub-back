package com.bovintech.versionone.application.company.command;

import com.bovintech.versionone.domain.company.model.CompanyShowDTO;
import com.bovintech.versionone.domain.company.model.CompanyUpdateDTO;
import com.bovintech.versionone.domain.company.service.CompanyUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyUpdateHandler {
    private final CompanyUpdateService companyUpdateService;

    public CompanyShowDTO execute (Long id, CompanyUpdateDTO updateDTO){
        return companyUpdateService.execute(id, updateDTO);
    }
}
