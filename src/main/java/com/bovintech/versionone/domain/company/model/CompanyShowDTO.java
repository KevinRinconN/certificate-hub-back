package com.bovintech.versionone.domain.company.model;

import lombok.Data;

@Data
public class CompanyShowDTO {
    private Long id;
    private String name;
    private String nit;
    private String address;
    private String email;
    private String phone;
    private String ciu;
}
