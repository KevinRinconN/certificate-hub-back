package com.bovintech.versionone.domain.certification.model;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CertificationDTO {
    private Long id;
    private Long consecutive;
    private Integer validateBy;
    private LocalDate date;
    private InspectorDTO inspector;
    private SeasonDTO season;
    private CompanyDTO company;
}
