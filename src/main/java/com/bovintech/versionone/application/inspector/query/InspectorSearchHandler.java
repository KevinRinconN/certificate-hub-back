package com.bovintech.versionone.application.inspector.query;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.query.InspectorSearchParams;
import com.bovintech.versionone.domain.Inspector.service.InspectorSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectorSearchHandler {

    private final InspectorSearchService inspectorSearchService;

    public Page<InspectorDTO> execute (InspectorSearchParams searchParams, Pageable pageable) {
        return inspectorSearchService.execute(searchParams, pageable);
    }
}
