package com.bovintech.versionone.domain.Inspector.usecases;

import com.bovintech.versionone.domain.Inspector.mapper.InspectorMapper;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorUpdateDTO;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.MappingTarget;

@RequiredArgsConstructor
public class InspectorUpdateUseCase {
    private final IinspectorRepository iinspectorRepository;
    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;

    public InspectorDTO execute (Long id, InspectorUpdateDTO updateDTO){
        InspectorDTO inspectorDTO = inspectorGetByIdUseCase.execute(id);
        InspectorMapper.INSTANCE.toUpdateFromDto(updateDTO,inspectorDTO);
        return iinspectorRepository.save(inspectorDTO);
    }
}
