package com.bovintech.versionone.domain.certification.model.certificate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InspectorCertificateDTO{
    private String username;
    private String displayName;
    private String occupation;
    private String signature;
}