package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.mapper.InspectorMapper;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorGetByIdService {
    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;

    public InspectorShow execute (String id){
        return InspectorMapper.INSTANCE.toShow(inspectorGetByIdUseCase.execute(id));
    }
}
