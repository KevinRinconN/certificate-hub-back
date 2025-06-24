package com.bovintech.versionone.application.department.bean;

import com.bovintech.versionone.domain.departament.port.repository.IDepartamentRepository;
import com.bovintech.versionone.domain.departament.service.DepartamentGetService;
import com.bovintech.versionone.domain.departament.service.DepartmentUpdateService;
import com.bovintech.versionone.domain.departament.usecases.DepartamentGetUseCase;
import com.bovintech.versionone.domain.departament.usecases.DepartmentUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfig {

    @Bean
    public DepartamentGetUseCase departamentGetUseCase (IDepartamentRepository iDepartamentRepository){
        return new DepartamentGetUseCase(iDepartamentRepository);
    }

    @Bean
    public DepartamentGetService departamentGetService (DepartamentGetUseCase departamentGetUseCase){
        return new DepartamentGetService(departamentGetUseCase);
    }

    @Bean
    public DepartmentUpdateUseCase departmentUpdateUseCase (IDepartamentRepository iDepartamentRepository, DepartamentGetUseCase departamentGetUseCase){
        return new DepartmentUpdateUseCase(iDepartamentRepository, departamentGetUseCase);
    }

    @Bean
    public DepartmentUpdateService departmentUpdateService (DepartmentUpdateUseCase departmentUpdateUseCase){
        return new DepartmentUpdateService(departmentUpdateUseCase);
    }
}
