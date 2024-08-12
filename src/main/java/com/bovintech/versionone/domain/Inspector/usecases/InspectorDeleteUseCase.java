package com.bovintech.versionone.domain.Inspector.usecases;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorDeleteUseCase {
    private final IinspectorRepository iinspectorRepository;
    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;

    public void execute (Long id){
        inspectorGetByIdUseCase.execute(id);
        iinspectorRepository.delete(id);
    }
}
