package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.query.InspectorSearchParams;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class InspectorSearchService {
    private final IinspectorRepository inspectorRepository;
    public Page<InspectorDTO> execute (InspectorSearchParams searchParams, Pageable pageable) {
        return inspectorRepository.search(searchParams,pageable);
    }
}
