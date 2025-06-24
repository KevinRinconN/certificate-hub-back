package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.company.service.CompanyGetByNameService;
import com.bovintech.versionone.domain.company.service.CompanySearchService;
import com.bovintech.versionone.domain.company.usecases.CompanyCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyBean {
    @Bean
    public CompanyFindByNitService companyFindByNitService(ICompanyRepository iCompanyRepository){
        return new CompanyFindByNitService(iCompanyRepository);
    }

    @Bean
    public CompanyGetByNameService companyGetByNameService(ICompanyRepository iCompanyRepository){
        return new CompanyGetByNameService(iCompanyRepository);
    }


    @Bean
    public CompanyCreateService companyCreateService(CompanyCreateUseCase companyCreateUseCase){
        return  new CompanyCreateService(companyCreateUseCase);
    }

    @Bean
    public CompanyCreateUseCase companyCreateUseCase(ICompanyRepository iCompanyRepository){
        return  new CompanyCreateUseCase(iCompanyRepository);
    }
}
