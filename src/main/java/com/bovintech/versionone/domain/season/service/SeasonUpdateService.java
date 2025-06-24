package com.bovintech.versionone.domain.season.service;

import com.bovintech.versionone.domain.season.mapper.SeasonMapper;
import com.bovintech.versionone.domain.season.model.SeasonUpdateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.usecases.SeasonUpdateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonUpdateService {
    private final SeasonUpdateUseCase seasonUpdateUseCase;

    public SeasonShow execute (Long id, SeasonUpdateDTO updateDTO){
        return SeasonMapper.INSTANCE.toShow(seasonUpdateUseCase.execute(id, updateDTO));
    }
}
