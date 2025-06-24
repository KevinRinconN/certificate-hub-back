package com.bovintech.versionone.domain.season.service;

import com.bovintech.versionone.domain.season.mapper.SeasonMapper;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.usecases.SeasonSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class SeasonFindService {
    private final SeasonSearchUseCase seasonSearchUseCase;

    public Page<SeasonShow> execute (SeasonSearchParams seasonSearchParams){
        Page<SeasonDTO> dto = seasonSearchUseCase.execute(seasonSearchParams);
        return dto.map(SeasonMapper.INSTANCE::toShow);
    }
}
