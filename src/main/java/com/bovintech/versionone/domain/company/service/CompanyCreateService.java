package com.bovintech.versionone.domain.company.service;

import com.bovintech.versionone.domain.company.mapper.CompanyShowMapper;
import com.bovintech.versionone.domain.company.model.CompanyCreateDTO;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.CompanyShowDTO;
import com.bovintech.versionone.domain.company.model.CompanyUpdateDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyBadRequest;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.usecases.CompanyCreateUseCase;
import lombok.RequiredArgsConstructor;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
public class CompanyCreateService {
    private final CompanyCreateUseCase companyCreateUseCase;

    public CompanyShowDTO execute(CompanyCreateDTO companyCreateDTO){
        CompanyDTO company = CompanyDTO.builder()
                .nit(companyCreateDTO.getNit())
                .email(companyCreateDTO.getEmail())
                .phone(companyCreateDTO.getPhone())
                .name(companyCreateDTO.getName())
                .certifications(new ArrayList<>())
                .build();
        return CompanyShowMapper.INSTANCE.toShow(companyCreateUseCase.execute(company));
    }
}
