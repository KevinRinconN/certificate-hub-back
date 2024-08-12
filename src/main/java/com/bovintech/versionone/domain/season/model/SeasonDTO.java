package com.bovintech.versionone.domain.season.model;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public class SeasonDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private List<CertificationDTO> certifications;
}
