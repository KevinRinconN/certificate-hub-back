package com.bovintech.versionone.domain.season.usecases;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.exception.SeasonErrorCatalog;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.domain.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonGetByIdUseCase {
    private final ISeasonRepository iSeasonRepository;

    public SeasonDTO execute(Long id){
        return iSeasonRepository.getById(id).orElseThrow(()-> new NotFoundException(SeasonErrorCatalog.SEASON_BY_ID_NOT_FOUND, "La temporada con el id "+id+" no fue encontrada"));
    }
}
