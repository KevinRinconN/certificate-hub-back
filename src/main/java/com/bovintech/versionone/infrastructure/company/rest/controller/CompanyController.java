package com.bovintech.versionone.infrastructure.company.rest.controller;

import com.bovintech.versionone.application.company.query.CompanySearchHandler;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanySearchHandler companySearchHandler;

    @GetMapping
    public ResponseHandler<Page<CompanyDTO>> search(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String nit,
                                                    @RequestParam(required = false) String address,
                                                    @RequestParam(required = false) String email,
                                                    @RequestParam(required = false) String phone,
                                                    @RequestParam(required = false) String ciu,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size,
                                                    @RequestParam(defaultValue = "id,asc") String sort) {
        CompanySearchParams params = new CompanySearchParams(name, nit, address,email,phone,ciu, page, size,sort);

        return ResponseHandler.success("", companySearchHandler.execute(params));
    }
}
