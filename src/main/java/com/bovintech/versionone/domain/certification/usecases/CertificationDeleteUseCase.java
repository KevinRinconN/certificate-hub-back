package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationDeleteUseCase {
    private final ICertificationRepository iCertificationRepository;
    private final CertificationGetByIdUseCase certificationGetByIdUseCase;

    public void execute(Long id){
        CertificationDTO certificationDTO =  certificationGetByIdUseCase.execute(id);
        iCertificationRepository.delete(certificationDTO.getId());
    }
}
