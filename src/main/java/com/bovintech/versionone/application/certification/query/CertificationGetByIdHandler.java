package com.bovintech.versionone.application.certification.query;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.service.CertificationGetByIdService;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationGetByIdHandler {
    private final CertificationGetByIdService getByIdService;

    public CertificateDTO execute (Long id){
        return getByIdService.execute(id);
    }
}
