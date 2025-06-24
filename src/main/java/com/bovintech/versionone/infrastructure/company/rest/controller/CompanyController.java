package com.bovintech.versionone.infrastructure.company.rest.controller;

import com.bovintech.versionone.application.company.command.CompanyUpdateHandler;
import com.bovintech.versionone.application.company.query.CompanyGetByIdHandler;
import com.bovintech.versionone.application.company.query.CompanySearchHandler;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CreateCertificationDTO;
import com.bovintech.versionone.domain.company.model.*;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanySearchHandler companySearchHandler;
    private final CompanyGetByIdHandler companyGetByIdHandler;
    private final CompanyUpdateHandler companyUpdateHandler;
    private final CompanyCreateService companyCreateService;

    @GetMapping
    public ResponseHandler<Page<CompanyShowDTO>> search(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String nit,
                                                        @RequestParam(required = false) String address,
                                                        @RequestParam(required = false) String email,
                                                        @RequestParam(required = false) String phone,
                                                        @RequestParam(required = false) String ciu,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "id,asc") String sort) {
        CompanySearchParams params = new CompanySearchParams(name, nit, address,email,phone,ciu, page, size,sort);

        return ResponseHandler.success("Company data successfully", companySearchHandler.execute(params));
    }

    @PostMapping
    public ResponseHandler<CompanyShowDTO> save(@RequestBody @Valid CompanyCreateDTO companyCreateDTO) {
        return ResponseHandler.success("The certifications have been successfully created.", companyCreateService.execute(companyCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseHandler<CompanyWithCertificatesShowDTO> findById (@PathVariable Long id){
        return ResponseHandler.success("Company data successfully", companyGetByIdHandler.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseHandler<CompanyShowDTO> update (@PathVariable Long id, @RequestBody @Valid CompanyUpdateDTO companyUpdateDTO){
        return ResponseHandler.success("Company update successfully", companyUpdateHandler.execute(id, companyUpdateDTO));
    }
}
