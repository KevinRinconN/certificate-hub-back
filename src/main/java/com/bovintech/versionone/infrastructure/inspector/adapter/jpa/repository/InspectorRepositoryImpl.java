package com.bovintech.versionone.infrastructure.inspector.adapter.jpa.repository;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorCreateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.query.InspectorSearchParams;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.infrastructure.inspector.adapter.jpa.IinspectorJpaRepository;
import com.bovintech.versionone.infrastructure.inspector.adapter.mapper.InspectorMapper;
import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import com.bovintech.versionone.infrastructure.util.ComparisonType;
import com.bovintech.versionone.infrastructure.util.SpecificationBuilder;
import com.bovintech.versionone.infrastructure.util.specification.GlobalSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InspectorRepositoryImpl implements IinspectorRepository {

    private final IinspectorJpaRepository iinspectorJpaRepository;
    private final InspectorMapper inspectorMapper;
    @Override
    public Optional<InspectorDTO> getById(Long id) {
        var optionalInspector = iinspectorJpaRepository.findById(id);
        return optionalInspector.map(inspectorMapper::toDomain);
    }

    @Override
    public Page<InspectorDTO> search(InspectorSearchParams searchParams, Pageable pageable) {
        Specification<InspectorEntity> specification = new SpecificationBuilder<InspectorEntity>()
                .with(searchParams.getFirstname(), "firstname", ComparisonType.LIKE)
                .with(searchParams.getLastname(), "lastname", ComparisonType.LIKE)
                .with(searchParams.getOccupation(), "occupation", ComparisonType.LIKE)
                .build();

        Page<InspectorEntity> entityPage = iinspectorJpaRepository.findAll(specification,pageable);
        return entityPage.map(inspectorMapper::toDomain);
    }

    @Override
    public InspectorDTO save(InspectorDTO inspector) {
        var inspectorToSave = inspectorMapper.toDbo(inspector);
        var inspectorSaved = iinspectorJpaRepository.save(inspectorToSave);
        return inspectorMapper.toDomain(inspectorSaved);
    }

    @Override
    public void delete(Long id) {
        iinspectorJpaRepository.deleteById(id);
    }
}
