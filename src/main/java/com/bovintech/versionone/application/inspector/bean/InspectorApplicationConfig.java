package com.bovintech.versionone.application.inspector.bean;

import com.bovintech.versionone.domain.Inspector.port.repository.IinspectorRepository;
import com.bovintech.versionone.domain.Inspector.service.InspectorDeleteService;
import com.bovintech.versionone.domain.Inspector.service.InspectorFindByIdService;
import com.bovintech.versionone.domain.Inspector.service.InspectorUpdateService;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorDeleteUseCase;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InspectorApplicationConfig {

    @Bean
    public InspectorFindByIdService inspectorFindByIdService (InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return new InspectorFindByIdService(inspectorGetByIdUseCase);
    }

    @Bean
    public InspectorGetByIdUseCase inspectorGetByIdUseCase (IinspectorRepository iinspectorRepository){
        return new InspectorGetByIdUseCase(iinspectorRepository);
    }

    @Bean
    public InspectorUpdateService inspectorUpdateService(InspectorUpdateUseCase inspectorUpdateUseCase){
        return new InspectorUpdateService(inspectorUpdateUseCase);
    }

    @Bean
    public InspectorUpdateUseCase inspectorUpdateUseCase(IinspectorRepository iinspectorRepository, InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return new InspectorUpdateUseCase(iinspectorRepository, inspectorGetByIdUseCase);
    }

    @Bean
    public InspectorDeleteService inspectorDeleteService(InspectorDeleteUseCase inspectorDeleteUseCase){
        return new InspectorDeleteService(inspectorDeleteUseCase);
    }

    @Bean
    public InspectorDeleteUseCase inspectorDeleteUseCase(IinspectorRepository iinspectorRepository, InspectorGetByIdUseCase inspectorGetByIdUseCase){
        return new InspectorDeleteUseCase(iinspectorRepository, inspectorGetByIdUseCase);
    }
}
