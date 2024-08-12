package com.bovintech.versionone.domain.certification.model.certificate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SeasonCertificateDTO{
    private Long id;
    private String name;
    private LocalDate startDate;
}