package com.bovintech.versionone.application.inspector.command;

import com.bovintech.versionone.domain.Inspector.service.InspectorDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InspectorDeleteHandler {
    private final InspectorDeleteService inspectorDeleteService;

    public void execute (Long id){
        inspectorDeleteService.execute(id);
    }
}
