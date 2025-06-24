package com.bovintech.versionone.domain.company.usecases;

import com.bovintech.versionone.domain.company.mapper.CompanyShowMapper;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.CompanyUpdateDTO;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyUpdateUseCase {
    private final ICompanyRepository iCompanyRepository;
    private final CompanyGetByIdUseCase companyGetByIdUseCase;

    public CompanyDTO execute (Long id, CompanyUpdateDTO companyUpdateDTO){
        CompanyDTO companyDTO = companyGetByIdUseCase.execute(id);
        CompanyShowMapper.INSTANCE.toUpdateFromDto(companyUpdateDTO, companyDTO);
        return iCompanyRepository.save(companyDTO);
    }
}
