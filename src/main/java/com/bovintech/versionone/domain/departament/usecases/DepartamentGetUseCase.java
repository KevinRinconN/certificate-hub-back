package com.bovintech.versionone.domain.departament.usecases;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.port.repository.IDepartamentRepository;
import com.bovintech.versionone.domain.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartamentGetUseCase {
    private final IDepartamentRepository iDepartamentRepository;

    public DepartamentDTO execute (){
        return iDepartamentRepository.findDepartament()
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
