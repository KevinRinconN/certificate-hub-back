package com.bovintech.versionone.domain.Inspector.usecases;

import com.bovintech.versionone.domain.Inspector.exception.InspectorErrorCatalog;
import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorGetByIdUseCase {
    private final IinspectorRepository iinspectorRepository;

    public InspectorDTO execute(Long id){
        return iinspectorRepository.getById(id).orElseThrow(()-> new NotFoundException(InspectorErrorCatalog.INSPECTOR_BY_ID_NOT_FOUND,"El inspector con el id "+id+" no fue encontrado"));
    }
}
