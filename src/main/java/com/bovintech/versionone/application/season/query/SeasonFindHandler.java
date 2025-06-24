package com.bovintech.versionone.application.season.query;

import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import com.bovintech.versionone.domain.season.service.SeasonFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeasonFindHandler {
    private final SeasonFindService seasonFindService;

    public Page<SeasonShow> execute (SeasonSearchParams seasonSearchParams){
        return seasonFindService.execute(seasonSearchParams);
    }
}
