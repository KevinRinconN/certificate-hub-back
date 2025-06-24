package com.bovintech.versionone.domain.company.model;


import lombok.Data;
import java.util.List;

@Data
public class CompanyWithCertificatesShowDTO extends CompanyShowDTO{
    private List<CompanyCertificateDTO> certificates;
}

