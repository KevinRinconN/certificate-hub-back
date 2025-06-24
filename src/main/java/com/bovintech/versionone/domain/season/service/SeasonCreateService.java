package com.bovintech.versionone.domain.season.service;

import com.bovintech.versionone.domain.season.mapper.SeasonMapper;
import com.bovintech.versionone.domain.season.model.SeasonCreateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.usecases.SeasonCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonCreateService {
    private final SeasonCreateUseCase seasonCreateUseCase;

    public SeasonShow execute(SeasonCreateDTO seasonCreateDTO){
        return SeasonMapper.INSTANCE.toShow(seasonCreateUseCase.execute(seasonCreateDTO));
    }
}
