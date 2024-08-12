package com.bovintech.versionone.infrastructure.season.adapter.jpa.repository;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.infrastructure.season.adapter.jpa.ISeasonJpaRepository;
import com.bovintech.versionone.infrastructure.season.adapter.mapper.SeasonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SeasonRepositoryImpl implements ISeasonRepository {

    private final ISeasonJpaRepository iSeasonJpaRepository;
    private final SeasonMapper seasonMapper;

    @Override
    public Optional<SeasonDTO> getById(Long id) {
        var optionalSeason = iSeasonJpaRepository.findById(id);

        return optionalSeason.map(seasonMapper::toDomain);
    }
}
