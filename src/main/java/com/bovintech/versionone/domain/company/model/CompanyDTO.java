package com.bovintech.versionone.domain.company.model;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyDTO {

    private Long id;
    private String name;
    private String nit;
    private String address;
    private String email;
    private String phone;
    private String ciu;

    private List<CertificationDTO> certifications;

}
