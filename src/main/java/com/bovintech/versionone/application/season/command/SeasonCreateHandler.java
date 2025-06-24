package com.bovintech.versionone.application.season.command;

import com.bovintech.versionone.domain.season.model.SeasonCreateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.service.SeasonCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeasonCreateHandler {
    private final SeasonCreateService seasonCreateService;

    public SeasonShow execute (SeasonCreateDTO seasonCreateDTO){
        return seasonCreateService.execute(seasonCreateDTO);
    }
}
