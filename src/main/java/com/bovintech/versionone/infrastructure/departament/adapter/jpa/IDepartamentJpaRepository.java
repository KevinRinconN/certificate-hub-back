package com.bovintech.versionone.infrastructure.departament.adapter.jpa;

import com.bovintech.versionone.infrastructure.departament.adapter.model.entity.DepartamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDepartamentJpaRepository extends JpaRepository<DepartamentEntity, Long> {
    Optional<DepartamentEntity> findFirstByOrderByIdAsc();
}
