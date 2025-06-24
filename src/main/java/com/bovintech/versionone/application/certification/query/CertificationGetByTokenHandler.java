package com.bovintech.versionone.application.certification.query;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.service.CertificationGetByTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationGetByTokenHandler {
    private final CertificationGetByTokenService certificationGetByTokenService;

    public CertificateDTO execute (String token){
        return certificationGetByTokenService.execute(token);
    }
}
