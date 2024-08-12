package com.bovintech.versionone.infrastructure.certification.adapter.jpa.repository;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.infrastructure.certification.adapter.jpa.ICertificationJpaRepository;
import com.bovintech.versionone.infrastructure.certification.adapter.mapper.CertificationMapper;
import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import com.bovintech.versionone.infrastructure.util.ComparisonType;
import com.bovintech.versionone.infrastructure.util.SpecificationBuilder;
import com.bovintech.versionone.infrastructure.util.pagination.SortUtils;
import com.bovintech.versionone.infrastructure.util.specification.GlobalSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CertificationRepositoryImpl implements ICertificationRepository {

    private final ICertificationJpaRepository iCertificationJpaRepository;
    private final CertificationMapper certificationMapper;
    @Override
    public Optional<Long> findLastConsecutiveBySeasonId(Long seasonId) {
        return iCertificationJpaRepository.findLastConsecutiveBySeasonId(seasonId);
    }

    @Override
    public CertificationDTO save(CertificationDTO certificationDTO) {
        var certificationToSave = certificationMapper.toDbo(certificationDTO);
        var certificationSaved = iCertificationJpaRepository.save(certificationToSave);
        return certificationMapper.toDomain(certificationSaved);
    }

    @Override
    public List<CertificationDTO> saveAll(List<CertificationDTO> certificationDTO) {
        var certificationsToSave = certificationDTO.stream()
                .map(certificationMapper::toDbo)
                .collect(Collectors.toList());
        var certificationsSaved = iCertificationJpaRepository.saveAll(certificationsToSave);
        return certificationsSaved.stream().map(certificationMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Page<CertificateDTO> findCertificates(CertificateSearchParams params) {
        Specification<CertificationEntity> specification = new SpecificationBuilder<CertificationEntity>()
                .withRelated(params.getNameCompany(), "company", "name", ComparisonType.LIKE)
                .build();

        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), SortUtils.createSort(params.getSort()));

        Page<CertificationEntity> entityPage = iCertificationJpaRepository.findAll(specification,pageable);
        Page<CertificationDTO> certificationDTO = entityPage.map(certificationMapper::toDomain);
        return certificationDTO.map(certificationMapper::toCertificate);
    }

    @Override
    public void delete(Long id) {
        iCertificationJpaRepository.deleteById(id);
    }

    @Override
    public Optional<CertificationDTO> getById(Long id) {
        return iCertificationJpaRepository.findById(id).map(certificationMapper::toDomain);
    }
}
