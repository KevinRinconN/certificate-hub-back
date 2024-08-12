package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.Inspector.service.InspectorFindByIdService;
import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.service.CertificationCreateService;
import com.bovintech.versionone.domain.certification.service.CertificationDeleteService;
import com.bovintech.versionone.domain.certification.service.CertificationFindService;
import com.bovintech.versionone.domain.certification.service.CertificationGetByIdService;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByIdUseCase;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.company.service.CompanyGetByNameService;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CertificationBean {



    @Bean
    public CertificationFindService certificationFindService(ICertificationRepository iCertificationRepository){
        return new CertificationFindService(iCertificationRepository);
    }

}
