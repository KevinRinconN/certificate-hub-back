package com.bovintech.versionone.application.certification.bean;

import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.service.*;
import com.bovintech.versionone.domain.certification.usecases.*;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.company.usecases.CompanyCreateUseCase;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
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
    public CertificationGetByIdService certificationGetByIdService(CertificationGetByIdUseCase getByIdUseCase, QrTokenGenerateUseCase qrTokenGenerateUseCase, DepartamentGetUseCase departamentGetUseCase) {
        return new CertificationGetByIdService(getByIdUseCase, qrTokenGenerateUseCase, departamentGetUseCase);
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
                                                                 CompanyCreateUseCase companyCreateUseCase,
                                                                 CompanyFindByNitService companyFindByNitService,
                                                                 SeasonGetByIdUseCase seasonGetByIdUseCase,
                                                                 InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return new CertificationCreateService(iCertificationRepository,companyCreateUseCase, companyFindByNitService,seasonGetByIdUseCase, inspectorGetByIdUseCase);
    }

    @Bean
    public QrTokenGenerateUseCase qrTokenGenerateUseCase (){
        return new QrTokenGenerateUseCase();
    }

    @Bean
    public CertificationGetByTokenService certificationGetByTokenService (CertificationGetByTokenUseCase certificationGetByTokenUseCase){
        return new CertificationGetByTokenService(certificationGetByTokenUseCase);
    }

    @Bean
    public CertificationGetByTokenUseCase certificationGetByTokenUseCase(QrTokenDetailsUseCase qrTokenDetailsUseCase,
                                                                         QrTokenValidateUseCase qrTokenValidateUseCase,
                                                                         CertificationGetByIdUseCase certificationGetByIdUseCase){
        return new CertificationGetByTokenUseCase(qrTokenValidateUseCase, qrTokenDetailsUseCase, certificationGetByIdUseCase);
    }

    @Bean
    public QrTokenValidateUseCase qrTokenValidateUseCase(){
        return new QrTokenValidateUseCase();
    }

    @Bean
    public QrTokenDetailsUseCase qrTokenDetailsUseCase(){
        return new QrTokenDetailsUseCase();
    }

    @Bean
    public CertificationGetByNitCompanyUseCase certificationGetByNitCompanyUseCase (CompanyFindByNitService companyFindByNitService){
        return new CertificationGetByNitCompanyUseCase(companyFindByNitService);
    }

    @Bean
    public CertificationByNitCompanyService certificationByNitCompanyService (CertificationGetByNitCompanyUseCase companyUseCase, QrTokenGenerateUseCase qrTokenGenerateUseCase){
        return new CertificationByNitCompanyService(companyUseCase, qrTokenGenerateUseCase);
    }
}
