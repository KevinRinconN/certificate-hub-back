package com.bovintech.versionone.infrastructure.auth.adapter.jpa;

import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserJpaRepository  extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
