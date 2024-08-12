package com.bovintech.versionone.application.certification.command;

import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.service.CertificationUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationUpdateHandler {
    private final CertificationUpdateService certificationUpdateService;

    public CertificateDTO execute(Long id, CertificationUpdateDTO certificationUpdateDTO){
        return certificationUpdateService.execute(id, certificationUpdateDTO);
    }
}
