package com.bovintech.versionone.infrastructure.certification.adapter.jpa;

import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICertificationJpaRepository extends JpaRepository<CertificationEntity, Long> , JpaSpecificationExecutor<CertificationEntity> {
    @Query("SELECT MAX(c.consecutive) FROM CertificationEntity c WHERE c.season.id = :seasonId")
    Optional<Long> findLastConsecutiveBySeasonId(@Param("seasonId") Long seasonId);

}
