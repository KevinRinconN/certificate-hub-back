package com.bovintech.versionone.domain.Inspector.port.repository;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.query.InspectorSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IinspectorRepository {
    Optional<InspectorDTO> getById(Long id);
    Page<InspectorDTO> search(InspectorSearchParams searchParams, Pageable pageable);
    InspectorDTO save(InspectorDTO inspector);

    void delete(Long id);
}
