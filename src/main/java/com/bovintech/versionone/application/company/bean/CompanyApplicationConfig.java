package com.bovintech.versionone.application.company.bean;

import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.service.CompanyGetByIdService;
import com.bovintech.versionone.domain.company.service.CompanySearchService;
import com.bovintech.versionone.domain.company.service.CompanyUpdateService;
import com.bovintech.versionone.domain.company.usecases.CompanyGetByIdUseCase;
import com.bovintech.versionone.domain.company.usecases.CompanySearchUseCase;
import com.bovintech.versionone.domain.company.usecases.CompanyUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyApplicationConfig {

    @Bean
    public CompanySearchService companySearchService (CompanySearchUseCase companySearchUseCase){
        return new CompanySearchService(companySearchUseCase);
    }

    @Bean
    public CompanySearchUseCase companySearchUseCase (ICompanyRepository iCompanyRepository){
        return new CompanySearchUseCase(iCompanyRepository);
    }

    @Bean
    public CompanyGetByIdService companyGetByIdService (CompanyGetByIdUseCase companyGetByIdUseCase){
        return new CompanyGetByIdService(companyGetByIdUseCase);
    }

    @Bean
    public CompanyGetByIdUseCase companyGetByIdUseCase(ICompanyRepository iCompanyRepository){
        return new CompanyGetByIdUseCase(iCompanyRepository);
    }

    @Bean
    public CompanyUpdateService companyUpdateService(CompanyUpdateUseCase companyUpdateUseCase){
        return new CompanyUpdateService(companyUpdateUseCase);
    }

    @Bean
    public CompanyUpdateUseCase companyUpdateUseCase(ICompanyRepository iCompanyRepository, CompanyGetByIdUseCase companyGetByIdUseCase){
        return new CompanyUpdateUseCase(iCompanyRepository, companyGetByIdUseCase);
    }

}
