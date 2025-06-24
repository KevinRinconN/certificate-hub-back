package com.bovintech.versionone.application.certification.query;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.service.CertificationByNitCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CertificationGetByNitCompanyHandler {
    private final CertificationByNitCompanyService certificationByNitCompanyService;

    public List<CertificateDTO> execute (String nit){
        return certificationByNitCompanyService.execute(nit);
    }
}
