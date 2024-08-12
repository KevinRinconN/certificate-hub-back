package com.bovintech.versionone.domain.company.port.repository;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface ICompanyRepository {
    Optional<CompanyDTO> findByNit(String nit);
    Optional<CompanyDTO> findById(Long id);
    Optional<CompanyDTO> findByName(String name);
    Page<CompanyDTO> search(CompanySearchParams companySearchParams);

    CompanyDTO save(CompanyDTO companyDTO);
}
