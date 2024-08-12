package com.bovintech.versionone.infrastructure.company.adapter.jpa;

import com.bovintech.versionone.infrastructure.company.adapter.model.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ICompanyJpaRepository extends JpaRepository<CompanyEntity, Long> , JpaSpecificationExecutor<CompanyEntity> {
    Optional<CompanyEntity> findByNit(String nit);
    Optional<CompanyEntity> findByName(String name);
}
