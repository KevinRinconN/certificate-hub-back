package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.certification.usecases.CertificationFindUseCase;
import com.bovintech.versionone.domain.certification.usecases.QrTokenGenerateUseCase;
import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.service.DepartamentGetService;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class  CertificationFindService {

    private final CertificationFindUseCase certificationFindUseCase;
    private final QrTokenGenerateUseCase qrTokenGenerateUseCase;
    private final DepartamentGetUseCase departamentGetUseCase;

    public Page<CertificateDTO> execute (CertificateSearchParams searchParams) {
        Page<CertificationDTO> dto = certificationFindUseCase.execute(searchParams);
        Page<CertificateDTO> show = dto.map(CertificationMapper.INSTANCE::toShow);

        DepartamentDTO department = departamentGetUseCase.execute();
        return show.map((certificate)->{
            certificate.setQrToken(qrTokenGenerateUseCase.execute(String.valueOf(certificate.getId())));
            certificate.setDepartment(department);
            return certificate;
        });
    }
}
