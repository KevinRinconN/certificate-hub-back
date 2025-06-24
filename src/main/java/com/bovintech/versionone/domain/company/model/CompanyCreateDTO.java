package com.bovintech.versionone.domain.company.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CompanyCreateDTO {
    @NotEmpty(message = "Nombre requerido")
    private String name;
    @NotEmpty(message = "Nit requerido")
    private String nit;
    private String email;
    private String phone;
}
