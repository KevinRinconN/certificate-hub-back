package com.bovintech.versionone.domain.departament.service;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.model.dto.DepartmentUpdateDTO;
import com.bovintech.versionone.domain.departament.usecases.DepartmentUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartmentUpdateService {
    private final DepartmentUpdateUseCase departmentUpdateUseCase;

    public DepartamentDTO execute (DepartmentUpdateDTO updateDTO) {
        return departmentUpdateUseCase.execute(updateDTO);
    }
}
