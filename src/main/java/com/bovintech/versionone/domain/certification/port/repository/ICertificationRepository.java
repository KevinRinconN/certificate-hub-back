package com.bovintech.versionone.domain.certification.port.repository;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICertificationRepository {
    Optional<Long> findLastConsecutiveBySeasonId(Long seasonId);
    CertificationDTO save(CertificationDTO certificationDTO);
    List<CertificationDTO> saveAll(List<CertificationDTO> certificationDTO);
    Page<CertificateDTO> findCertificates(CertificateSearchParams cattleSearchParams);
    void delete(Long id);
    Optional<CertificationDTO> getById(Long id);
}
