package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.usecases.CertificationUpdateUseCase;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationUpdateService {
    private final CertificationUpdateUseCase certificationUpdateUseCase;

    public CertificateDTO execute(Long id, CertificationUpdateDTO certificationUpdateDTO){
        return CertificationMapper.INSTANCE.toShow(certificationUpdateUseCase.execute(id, certificationUpdateDTO));
    }

}
