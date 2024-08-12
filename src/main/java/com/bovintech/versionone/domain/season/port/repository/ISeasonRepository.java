package com.bovintech.versionone.domain.season.port.repository;

import com.bovintech.versionone.domain.season.model.SeasonDTO;

import java.util.Optional;

public interface ISeasonRepository {
    Optional<SeasonDTO> getById(Long id);
}
