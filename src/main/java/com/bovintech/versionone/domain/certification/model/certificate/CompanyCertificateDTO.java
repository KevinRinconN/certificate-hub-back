package com.bovintech.versionone.domain.certification.model.certificate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyCertificateDTO{
    private Long id;
    private String name;
    private String nit;
    private String phone;
    private String email;
}
