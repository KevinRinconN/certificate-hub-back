package com.bovintech.versionone.domain.certification.model.certificate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CertificateDTO {
    private Long id;
    private Long consecutive;
    private Integer validateBy;
    private LocalDate date;
    private InspectorCertificateDTO inspector;
    private SeasonCertificateDTO season;
    private CompanyCertificateDTO company;
}

