package com.bovintech.versionone.infrastructure.season.adapter.jpa;

import com.bovintech.versionone.infrastructure.season.adapter.model.entity.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonJpaRepository  extends JpaRepository<SeasonEntity, Long> {
}
