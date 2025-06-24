package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.mapper.CompanyShowMapper;
import com.bovintech.versionone.domain.company.model.CompanyShowDTO;
import com.bovintech.versionone.domain.company.model.CompanyUpdateDTO;
import com.bovintech.versionone.domain.company.usecases.CompanyUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyUpdateService {
    private final CompanyUpdateUseCase companyUpdateUseCase;

    public CompanyShowDTO execute(Long id, CompanyUpdateDTO companyUpdateDTO){
        return CompanyShowMapper.INSTANCE.toShow(companyUpdateUseCase.execute(id, companyUpdateDTO));
    }
}
