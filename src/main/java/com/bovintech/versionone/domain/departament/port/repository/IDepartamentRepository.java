package com.bovintech.versionone.domain.departament.port.repository;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;

import java.util.Optional;

public interface IDepartamentRepository {
    Optional<DepartamentDTO> findDepartament();
    DepartamentDTO save(DepartamentDTO dto);
}
