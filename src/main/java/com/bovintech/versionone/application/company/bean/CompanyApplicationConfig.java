package com.bovintech.versionone.application.company.bean;

import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.service.CompanySearchService;
import com.bovintech.versionone.domain.company.usecases.CompanySearchUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CompanySearchService companySearchService (CompanySearchUseCase companySearchUseCase){
        return new CompanySearchService(companySearchUseCase);
    }

    @Bean
    public CompanySearchUseCase companySearchUseCase (ICompanyRepository iCompanyRepository){
        return new CompanySearchUseCase(iCompanyRepository);
    }
}
