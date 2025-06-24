package com.bovintech.versionone.domain.company.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CompanyCertificateDTO {
    private Long id;
    private String consecutive;
    private String ClientConsecutive;
    private String address;
    private String ciiu;
    private Integer validateBy;
    private LocalDate date;
}

