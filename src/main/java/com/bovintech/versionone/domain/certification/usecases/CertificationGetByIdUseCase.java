package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.constant.CertificationErrorCatalog;
import com.bovintech.versionone.domain.certification.model.exception.CertificationNotFoundException;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationGetByIdUseCase {
    private final ICertificationRepository certificationRepository;

    public CertificationDTO execute (Long id){
        return certificationRepository.getById(id)
                .orElseThrow(()->new CertificationNotFoundException(CertificationErrorCatalog.CERTIFICATION_NOT_FOUND,
                        "El certificado con el id: "+id+" no fue encontrado"));
    }
}
