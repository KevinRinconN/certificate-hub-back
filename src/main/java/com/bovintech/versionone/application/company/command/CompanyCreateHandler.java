package com.bovintech.versionone.application.company.command;

import com.bovintech.versionone.domain.company.model.CompanyCreateDTO;
import com.bovintech.versionone.domain.company.model.CompanyShowDTO;
import com.bovintech.versionone.domain.company.model.CompanyUpdateDTO;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyCreateHandler {
    private final CompanyCreateService companyCreateService;

    public CompanyShowDTO execute (CompanyCreateDTO companyCreateDTO){
        return companyCreateService.execute(companyCreateDTO);
    }
}
