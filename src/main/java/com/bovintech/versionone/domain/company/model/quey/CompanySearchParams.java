package com.bovintech.versionone.domain.company.model.quey;

import com.bovintech.versionone.domain.util.dto.PaginationParams;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanySearchParams extends PaginationParams {
    private String name;
    private String nit;
    private String address;
    private String email;
    private String phone;
    private String ciu;

    public CompanySearchParams(String name, String nit, String address, String email, String phone, String ciu, int page, int size, String sort) {
        super(page, size, sort);
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.ciu = ciu;
    }
}
