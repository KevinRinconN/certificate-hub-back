package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.usecases.CertificationDeleteUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationDeleteService {

    private final CertificationDeleteUseCase certificationDeleteUseCase;

    public void execute (Long id){
        certificationDeleteUseCase.execute(id);
    }

}
