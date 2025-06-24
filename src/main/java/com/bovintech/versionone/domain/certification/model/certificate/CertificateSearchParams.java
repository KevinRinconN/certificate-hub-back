package com.bovintech.versionone.domain.certification.model.certificate;

import com.bovintech.versionone.domain.util.dto.PaginationParams;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateSearchParams extends PaginationParams {


    private String nit;
    private String nameCompany;
    private List<String> inspectors;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha de inicio debe estar en formato 'yyyy-MM-dd'")
    private String startDate;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha de fin debe estar en formato 'yyyy-MM-dd'")
    private String endDate;

    public CertificateSearchParams(String nit, String nameCompany, String startDate, String endDate, List<String> inspectors,  int page, int size, String sort) {
        super(page, size, sort);
        this.nameCompany = nameCompany;
        this.nit = nit;
        this.inspectors = inspectors;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}