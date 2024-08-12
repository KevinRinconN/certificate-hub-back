package com.bovintech.versionone.application.inspector.command;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorUpdateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.service.InspectorUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectorUpdateHandler {
    private final InspectorUpdateService inspectorUpdateService;

    public InspectorShow execute (Long id, InspectorUpdateDTO inspectorUpdateDTO){
        return inspectorUpdateService.execute(id, inspectorUpdateDTO);
    }
}
