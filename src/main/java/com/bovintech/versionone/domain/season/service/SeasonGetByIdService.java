package com.bovintech.versionone.domain.season.service;

import com.bovintech.versionone.domain.season.mapper.SeasonMapper;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.exception.SeasonErrorCatalog;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import com.bovintech.versionone.domain.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonGetByIdService {

    private final SeasonGetByIdUseCase seasonGetByIdUseCase;

    public SeasonShow execute (Long id) {
       return SeasonMapper.INSTANCE.toShow(seasonGetByIdUseCase.execute(id));
    }
}
