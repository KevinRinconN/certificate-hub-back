package com.bovintech.versionone.application.department.command;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.model.dto.DepartmentUpdateDTO;
import com.bovintech.versionone.domain.departament.service.DepartmentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeparmentUpdateHandler {
    private final DepartmentUpdateService departmentUpdateService;

    public DepartamentDTO execute (DepartmentUpdateDTO updateDTO){
        return departmentUpdateService.execute(updateDTO);
    }
}
