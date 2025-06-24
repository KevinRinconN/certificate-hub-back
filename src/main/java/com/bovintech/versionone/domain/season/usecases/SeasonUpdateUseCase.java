package com.bovintech.versionone.domain.season.usecases;

import com.bovintech.versionone.domain.season.mapper.SeasonMapper;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonUpdateDTO;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonUpdateUseCase {
    private final ISeasonRepository iSeasonRepository;
    private final SeasonGetByIdUseCase seasonGetByIdUseCase;

    public SeasonDTO execute (Long id, SeasonUpdateDTO seasonUpdateDTO) {
        SeasonDTO seasonDTO = seasonGetByIdUseCase.execute(id);
        SeasonMapper.INSTANCE.toUpdateFromDto(seasonUpdateDTO, seasonDTO);
        return iSeasonRepository.save(seasonDTO);
    }
}
