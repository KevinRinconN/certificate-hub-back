package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.mapper.InspectorMapper;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorUpdateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorUpdateService {
    private final InspectorUpdateUseCase inspectorUpdateUseCase;

    public InspectorShow execute(Long id, InspectorUpdateDTO inspectorUpdateDTO){
        return InspectorMapper.INSTANCE.toShow(inspectorUpdateUseCase.execute(id, inspectorUpdateDTO));
    }
}
