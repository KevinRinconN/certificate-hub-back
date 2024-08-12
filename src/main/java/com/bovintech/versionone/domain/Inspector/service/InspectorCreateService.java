package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.mapper.InspectorMapper;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorCreateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorCreateService {

    private final InspectorCreateUseCase inspectorCreateUseCase;
    public InspectorShow execute (InspectorCreateDTO inspectorCreateDTO){
        return InspectorMapper.INSTANCE.toShow(inspectorCreateUseCase.execute(inspectorCreateDTO));
    }
}
