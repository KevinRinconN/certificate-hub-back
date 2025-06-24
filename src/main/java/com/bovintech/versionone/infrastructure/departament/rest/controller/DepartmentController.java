package com.bovintech.versionone.infrastructure.departament.rest.controller;

import com.bovintech.versionone.application.department.command.DepartmentUpdateHandler;
import com.bovintech.versionone.application.department.query.DepartmentGetHandler;
import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.model.dto.DepartmentUpdateDTO;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentGetHandler departmentGetHandler;
    private final DepartmentUpdateHandler departmentUpdateHandler;

    @GetMapping
    public ResponseHandler<DepartamentDTO> get (){
        return ResponseHandler.success("Department data successfully", departmentGetHandler.execute());
    }

    @PutMapping
    public ResponseHandler<DepartamentDTO> update (@RequestBody @Valid DepartmentUpdateDTO updateDTO){
        DepartamentDTO department = departmentUpdateHandler.execute(updateDTO);
        return ResponseHandler.success("Department data update successfully", department);
    }
}
