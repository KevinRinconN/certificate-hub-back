package com.bovintech.versionone.domain.departament.usecases;

import com.bovintech.versionone.domain.departament.mapper.DepartmentMapper;
import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.model.dto.DepartmentUpdateDTO;
import com.bovintech.versionone.domain.departament.port.repository.IDepartamentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartmentUpdateUseCase {
    private final IDepartamentRepository iDepartamentRepository;
    private final DepartamentGetUseCase departamentGetUseCase;

    public DepartamentDTO execute (DepartmentUpdateDTO updateDTO) {
        DepartamentDTO departamentToUpdate = departamentGetUseCase.execute();

        DepartmentMapper.INSTANCE.toUpdateFromDto(updateDTO, departamentToUpdate);
        return iDepartamentRepository.save(departamentToUpdate);
    }
}
