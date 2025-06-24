package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.service.CertificationFindService;
import com.bovintech.versionone.domain.certification.usecases.CertificationFindUseCase;
import com.bovintech.versionone.domain.certification.usecases.QrTokenGenerateUseCase;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CertificationBean {

    @Bean
    public CertificationFindService certificationFindService(CertificationFindUseCase certificationFindUseCase, QrTokenGenerateUseCase qrTokenGenerateUseCase, DepartamentGetUseCase departamentGetUseCase) {
        return new CertificationFindService(certificationFindUseCase, qrTokenGenerateUseCase, departamentGetUseCase);
    }

    @Bean
    public CertificationFindUseCase certificationFindUseCase (ICertificationRepository iCertificationRepository){
        return new CertificationFindUseCase(iCertificationRepository);
    }

}
