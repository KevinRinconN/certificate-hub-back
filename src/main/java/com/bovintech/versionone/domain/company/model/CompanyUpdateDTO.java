package com.bovintech.versionone.domain.company.model;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import lombok.Data;

@Data
@AtLeastOneField(fields = {"name", "nit", "email", "phone"}, message = "Debe especificar al menos uno de los campos: name, nit, email o phone")
public class CompanyUpdateDTO {
    private String name;
    private String nit;
    private String email;
    private String phone;
}
