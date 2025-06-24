package com.bovintech.versionone.domain.departament.service;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartamentGetService {
    private final DepartamentGetUseCase departamentGetUseCase;

    public DepartamentDTO execute () {
        return  departamentGetUseCase.execute();
    }
}
