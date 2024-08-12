package com.bovintech.versionone.domain.Inspector.usecases;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorCreateDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorCreateUseCase {
    private final IinspectorRepository inspectorRepository;

    public InspectorDTO execute (InspectorCreateDTO inspectorCreateDTO){
        InspectorDTO inspectorDTO = InspectorDTO.builder()
                .username(inspectorCreateDTO.getUsername())
                .firstname(inspectorCreateDTO.getFirstname())
                .lastname(inspectorCreateDTO.getLastname())
                .occupation(inspectorCreateDTO.getOccupation())
                .displayName(inspectorCreateDTO.getDisplayName())
                .signature(inspectorCreateDTO.getSignature())
                .build();

        return inspectorRepository.save(inspectorDTO);
    }
}
