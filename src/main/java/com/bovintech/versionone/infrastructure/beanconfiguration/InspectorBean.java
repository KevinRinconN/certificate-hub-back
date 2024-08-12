package com.bovintech.versionone.infrastructure.beanconfiguration;

import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.Inspector.service.InspectorCreateService;
import com.bovintech.versionone.domain.Inspector.service.InspectorFindByIdService;
import com.bovintech.versionone.domain.Inspector.service.InspectorSearchService;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InspectorBean {

    @Bean
    public InspectorSearchService inspectorSearchService(IinspectorRepository inspectorRepository){
        return new InspectorSearchService(inspectorRepository);
    }

    @Bean
    public InspectorCreateService inspectorCreateService (InspectorCreateUseCase inspectorCreateUseCase){
        return new InspectorCreateService(inspectorCreateUseCase);
    }

    @Bean
    public InspectorCreateUseCase inspectorCreateUseCase (IinspectorRepository iinspectorRepository){
        return new InspectorCreateUseCase(iinspectorRepository);
    }
}

