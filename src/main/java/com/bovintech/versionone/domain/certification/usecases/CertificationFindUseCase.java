package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class CertificationFindService {
    private final ICertificationRepository iCertificationRepository;

    public Page<CertificationDTO> execute (CertificateSearchParams searchParams) {
        return iCertificationRepository.findCertificates(searchParams);
    }
}
