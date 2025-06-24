package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.usecases.CertificationGetByIdUseCase;
import com.bovintech.versionone.domain.certification.usecases.QrTokenGenerateUseCase;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationGetByIdService {

    private final CertificationGetByIdUseCase getByIdUseCase;
    private final QrTokenGenerateUseCase qrTokenGenerateUseCase;
    private final DepartamentGetUseCase departamentGetUseCase;

    public CertificateDTO execute (Long id){
        CertificateDTO dto = CertificationMapper.INSTANCE.toShow(getByIdUseCase.execute(id));
        dto.setQrToken(qrTokenGenerateUseCase.execute("kevin"));
        dto.setDepartment(departamentGetUseCase.execute());
        return dto;
    }
}
