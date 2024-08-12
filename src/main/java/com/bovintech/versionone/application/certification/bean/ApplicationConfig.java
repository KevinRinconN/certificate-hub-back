package com.bovintech.versionone.application.certification.bean;

import com.bovintech.versionone.domain.Inspector.service.InspectorFindByIdService;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.service.CertificationCreateService;
import com.bovintech.versionone.domain.certification.service.CertificationDeleteService;
import com.bovintech.versionone.domain.certification.service.CertificationGetByIdService;
import com.bovintech.versionone.domain.certification.service.CertificationUpdateService;
import com.bovintech.versionone.domain.certification.usecases.CertificationDeleteUseCase;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByIdUseCase;
import com.bovintech.versionone.domain.certification.usecases.CertificationUpdateUseCase;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyGetByNameService;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CertificationGetByIdUseCase certificationGetByIdUseCase(ICertificationRepository certificationRepository) {
        return new CertificationGetByIdUseCase(certificationRepository);
    }

    @Bean
    public CertificationGetByIdService certificationGetByIdService(CertificationGetByIdUseCase getByIdUseCase) {
        return new CertificationGetByIdService(getByIdUseCase);
    }

    @Bean
    public CertificationDeleteService certificationDeleteService(CertificationDeleteUseCase certificationDeleteUseCase){
        return new CertificationDeleteService(certificationDeleteUseCase);
    }

    @Bean
    public CertificationDeleteUseCase certificationDeleteUseCase(ICertificationRepository iCertificationRepository, CertificationGetByIdUseCase certificationGetByIdUseCase){
        return new CertificationDeleteUseCase(iCertificationRepository, certificationGetByIdUseCase);
    }

    @Bean
    public CertificationUpdateService certificationUpdateService(CertificationUpdateUseCase certificationUpdateUseCase){
        return new CertificationUpdateService(certificationUpdateUseCase);
    }

    @Bean
    public CertificationUpdateUseCase certificationUpdateUseCase(ICertificationRepository iCertificationRepository,
                                                                 CertificationGetByIdUseCase certificationGetByIdUseCase,
                                                                 SeasonGetByIdUseCase seasonGetByIdUseCase,
                                                                 InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return  new CertificationUpdateUseCase(iCertificationRepository,certificationGetByIdUseCase, seasonGetByIdUseCase, inspectorGetByIdUseCase);
    }

    @Bean
    public CertificationCreateService certificationCreateService(ICertificationRepository iCertificationRepository,
                                                                 CompanyCreateService companyCreateService,
                                                                 CompanyGetByNameService companyGetByNameService,
                                                                 SeasonGetByIdUseCase seasonGetByIdUseCase,
                                                                 InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return new CertificationCreateService(iCertificationRepository,companyCreateService, companyGetByNameService,seasonGetByIdUseCase, inspectorGetByIdUseCase);
    }
}
