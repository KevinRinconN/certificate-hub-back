package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.company.service.CompanyGetByNameService;
import com.bovintech.versionone.domain.company.service.CompanySearchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyBean {
    @Bean
    public CompanyFindByNitService companyFindByNitService(ICompanyRepository iCompanyRepository){
        return new CompanyFindByNitService(iCompanyRepository);
    }

    @Bean
    public CompanyGetByNameService companyGetByIdService(ICompanyRepository iCompanyRepository){
        return new CompanyGetByNameService(iCompanyRepository);
    }

    @Bean
    public CompanySearchService companySearchService (ICompanyRepository iCompanyRepository){
        return new CompanySearchService(iCompanyRepository);
    }

    @Bean
    public CompanyCreateService companyCreateService(ICompanyRepository iCompanyRepository){
        return  new CompanyCreateService(iCompanyRepository);
    }
}
