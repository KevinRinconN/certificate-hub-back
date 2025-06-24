package com.bovintech.versionone.domain.season.usecases;

import com.bovintech.versionone.domain.season.model.SeasonCreateDTO;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SeasonCreateUseCase {
    private final ISeasonRepository iSeasonRepository;

    public SeasonDTO execute (SeasonCreateDTO seasonCreateDTO){
        SeasonDTO seasonDTO = SeasonDTO.builder()
                .name(seasonCreateDTO.getName())
                .prefix(seasonCreateDTO.getPrefix())
                .startDate(seasonCreateDTO.getStartDate())
                .build();

        return iSeasonRepository.save(seasonDTO);
    }
}
