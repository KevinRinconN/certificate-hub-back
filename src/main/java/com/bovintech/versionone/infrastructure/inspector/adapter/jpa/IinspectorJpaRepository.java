package com.bovintech.versionone.infrastructure.inspector.adapter.jpa;

import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IinspectorJpaRepository extends JpaRepository<InspectorEntity, String>, JpaSpecificationExecutor<InspectorEntity> {

}
