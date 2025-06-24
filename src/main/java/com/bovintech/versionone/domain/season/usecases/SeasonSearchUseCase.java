package com.bovintech.versionone.domain.season.usecases;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class SeasonSearchUseCase {
    private final ISeasonRepository iSeasonRepository;

    public Page<SeasonDTO> execute (SeasonSearchParams seasonSearchParams){
        return iSeasonRepository.find(seasonSearchParams);
    }
}
