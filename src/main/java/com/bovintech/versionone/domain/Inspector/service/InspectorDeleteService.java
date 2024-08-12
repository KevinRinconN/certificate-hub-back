package com.bovintech.versionone.domain.Inspector.service;

import com.bovintech.versionone.domain.Inspector.usecases.InspectorDeleteUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InspectorDeleteService {
    private final InspectorDeleteUseCase inspectorDeleteUseCase;

    public void execute (Long id){
        inspectorDeleteUseCase.execute(id);
    }
}
