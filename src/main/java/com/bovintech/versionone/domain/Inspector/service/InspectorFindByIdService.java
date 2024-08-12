package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.exception.InspectorErrorCatalog;
import com.bovintech.versionone.domain.Inspector.mapper.InspectorMapper;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.show.InspectorShow;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorFindByIdService {

    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;

    public InspectorShow execute (Long id) {
        return InspectorMapper.INSTANCE.toShow(inspectorGetByIdUseCase.execute(id));
    }
}
