package com.bovintech.versionone.domain.season.port.repository;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ISeasonRepository {
    Optional<SeasonDTO> getById(Long id);
    Page<SeasonDTO> find (SeasonSearchParams searchParams);
    SeasonDTO save(SeasonDTO seasonDTO);
}
