package com.bovintech.versionone.infrastructure.inspector.adapter.jpa;

import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IinspectorJpaRepository extends JpaRepository<InspectorEntity, Long>, JpaSpecificationExecutor<InspectorEntity> {

}
