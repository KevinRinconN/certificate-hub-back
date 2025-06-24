package com.bovintech.versionone.domain.certification.model.certificate;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CertificateDTO {
    private Long id;
    private String formattedConsecutive;
    private String qrToken;
    private String consecutive;
    private String clientConsecutive;
    private String address;
    private String nameCompany;
    private String phone;
    private String email;
    private String ciu;
    private Integer validateBy;
    private boolean valid;
    private LocalDate date;
    private InspectorCertificateDTO inspector;
    private SeasonCertificateDTO season;
    private CompanyCertificateDTO company;
    private DepartamentDTO department;
}

