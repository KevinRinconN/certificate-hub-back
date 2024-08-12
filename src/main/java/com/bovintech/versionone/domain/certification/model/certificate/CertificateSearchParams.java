package com.bovintech.versionone.domain.certification.model.certificate;

import com.bovintech.versionone.domain.util.dto.PaginationParams;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateSearchParams extends PaginationParams {
    private String nameCompany;

    public CertificateSearchParams(String nameCompany, int page, int size, String sort) {
        super(page, size, sort);
        this.nameCompany = nameCompany;
    }

}