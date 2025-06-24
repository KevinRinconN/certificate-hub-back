package com.bovintech.versionone.application.department.query;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.service.DepartamentGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentGetHandler {
    private final DepartamentGetService departamentGetService;

    public DepartamentDTO execute (){
        return departamentGetService.execute();
    }
}
