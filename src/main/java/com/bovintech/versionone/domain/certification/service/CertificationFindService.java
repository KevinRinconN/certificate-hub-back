package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class  CertificationFindService {

    private final ICertificationRepository iCertificationRepository;

    public Page<CertificateDTO> execute (CertificateSearchParams searchParams) {
        return iCertificationRepository.findCertificates(searchParams);
    }
}
