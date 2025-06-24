package com.bovintech.versionone.application.season.query;

import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeasonGetByIdHandler {
    private final SeasonGetByIdService seasonGetByIdService;

    public SeasonShow execute(Long id){
        return  seasonGetByIdService.execute(id);
    }
}
