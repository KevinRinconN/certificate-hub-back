package com.bovintech.versionone.application.certification.command;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CreateCertificationDTO;
import com.bovintech.versionone.domain.certification.service.CertificationCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CertificationCreateHandler {

    private final CertificationCreateService certificationCreateService;
    public List<CertificationDTO> execute (List<CreateCertificationDTO> createCertificationDTO){
        return certificationCreateService.execute(createCertificationDTO);
    }

    public CertificationDTO execute (CreateCertificationDTO certificationDTO){
        return certificationCreateService.execute(certificationDTO);
    }
}
