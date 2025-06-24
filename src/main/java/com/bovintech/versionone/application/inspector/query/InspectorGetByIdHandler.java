package com.bovintech.versionone.application.inspector.query;

import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.service.InspectorGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectorGetByIdHandler {
    private final InspectorGetByIdService inspectorGetByIdService;

    public InspectorShow execute (String id){
        return inspectorGetByIdService.execute(id);
    }
}
