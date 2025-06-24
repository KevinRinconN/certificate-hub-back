package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByTokenUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationGetByTokenService {
    private final CertificationGetByTokenUseCase certificationGetByTokenUseCase;

    public CertificateDTO execute (String token){
        CertificateDTO dto = CertificationMapper.INSTANCE.toShow(certificationGetByTokenUseCase.execute(token));
        dto.setQrToken(token);
        return dto;
    }
}
