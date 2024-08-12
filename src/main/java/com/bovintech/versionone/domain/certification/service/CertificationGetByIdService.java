package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationGetByIdService {

    private final CertificationGetByIdUseCase getByIdUseCase;

    public CertificateDTO execute (Long id){
        return CertificationMapper.INSTANCE.toShow(getByIdUseCase.execute(id));
    }
}
