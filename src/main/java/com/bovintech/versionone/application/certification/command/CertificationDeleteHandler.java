package com.bovintech.versionone.application.certification.command;

import com.bovintech.versionone.domain.certification.service.CertificationDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationDeleteHandler {
    private final CertificationDeleteService certificationDeleteService;

    public void execute (Long id){
        certificationDeleteService.execute(id);
    }
}
