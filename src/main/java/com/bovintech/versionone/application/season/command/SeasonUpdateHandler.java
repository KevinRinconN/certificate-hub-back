package com.bovintech.versionone.application.season.command;

import com.bovintech.versionone.domain.season.model.SeasonUpdateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.service.SeasonUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeasonUpdateHandler {
    private final SeasonUpdateService seasonUpdateService;

    public SeasonShow execute (Long id, SeasonUpdateDTO updateDTO){
        return seasonUpdateService.execute(id, updateDTO);
    }
}
