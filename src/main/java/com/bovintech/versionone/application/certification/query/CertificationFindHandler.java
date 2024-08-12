package com.bovintech.versionone.application.certification.query;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.domain.certification.service.CertificationFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationFindHandler {

    private final CertificationFindService certificationFindService;

    public Page<CertificateDTO> execute (CertificateSearchParams searchParams) {
        return certificationFindService.execute(searchParams);
    }
}
