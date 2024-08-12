package com.bovintech.versionone.domain.Inspector.model.dto;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class InspectorDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String displayName;
    private String occupation;
    private String signature;

    private List<CertificationDTO> certifications;
}
