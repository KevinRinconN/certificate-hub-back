package com.bovintech.versionone.application.season.bean;

import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeasonApplicationConfig {

    @Bean
    public SeasonGetByIdService seasonGetByIdService (SeasonGetByIdUseCase seasonGetByIdUseCase){
        return new SeasonGetByIdService(seasonGetByIdUseCase);
    }

    @Bean
    public SeasonGetByIdUseCase seasonGetByIdUseCase(ISeasonRepository iSeasonRepository){
        return new SeasonGetByIdUseCase(iSeasonRepository);
    }
}
