package com.bovintech.versionone.application.inspector.command;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorCreateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.service.InspectorCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectorCreateHandler {
    private final InspectorCreateService inspectorCreateService;

    public InspectorShow execute(InspectorCreateDTO inspectorCreateDTO){
        return inspectorCreateService.execute(inspectorCreateDTO);
    }
}
