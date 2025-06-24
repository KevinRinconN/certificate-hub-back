package com.bovintech.versionone.application.season.bean;

import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.domain.season.service.SeasonCreateService;
import com.bovintech.versionone.domain.season.service.SeasonFindService;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import com.bovintech.versionone.domain.season.service.SeasonUpdateService;
import com.bovintech.versionone.domain.season.usecases.SeasonCreateUseCase;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import com.bovintech.versionone.domain.season.usecases.SeasonSearchUseCase;
import com.bovintech.versionone.domain.season.usecases.SeasonUpdateUseCase;
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

   @Bean
   public SeasonFindService seasonFindService(SeasonSearchUseCase seasonSearchUseCase){
        return new SeasonFindService(seasonSearchUseCase);
   }

   @Bean
    public SeasonSearchUseCase seasonSearchUseCase(ISeasonRepository iSeasonRepository){
        return new SeasonSearchUseCase(iSeasonRepository);
   }

   @Bean
    public SeasonCreateService seasonCreateService(SeasonCreateUseCase seasonCreateUseCase){
        return new SeasonCreateService(seasonCreateUseCase);
   }

   @Bean
    public SeasonCreateUseCase seasonCreateUseCase (ISeasonRepository iSeasonRepository){
        return new SeasonCreateUseCase(iSeasonRepository);
   }

   @Bean
    public SeasonUpdateService seasonUpdateService(SeasonUpdateUseCase seasonUpdateUseCase){
        return new SeasonUpdateService(seasonUpdateUseCase);
   }

   @Bean
    public SeasonUpdateUseCase seasonUpdateUseCase(ISeasonRepository iSeasonRepository, SeasonGetByIdUseCase seasonGetByIdUseCase){
        return new SeasonUpdateUseCase(iSeasonRepository, seasonGetByIdUseCase);
   }
}
