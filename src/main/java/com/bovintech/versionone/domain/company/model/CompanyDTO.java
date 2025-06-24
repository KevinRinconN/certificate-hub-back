package com.bovintech.versionone.domain.company.model;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import jakarta.validation.constraints.NotEmpty;
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
    private String email;
    private String phone;


    private List<CertificationDTO> certifications;

}
