package com.bovintech.versionone.domain.certification.model.certificate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyCertificateDTO{
    private String name;
    private String nit;
    private String address;
    private String ciu;
}
