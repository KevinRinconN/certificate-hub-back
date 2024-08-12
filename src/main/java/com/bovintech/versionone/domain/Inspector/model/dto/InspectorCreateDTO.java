package com.bovintech.versionone.domain.Inspector.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class InspectorCreateDTO {

    @NotEmpty(message = "username requerido")
    private String username;
    @NotEmpty(message = "firstname requerido")
    private String firstname;
    @NotEmpty(message = "lastname requerido")
    private String lastname;
    @NotEmpty(message = "displayName requerido")
    private String displayName;
    @NotEmpty(message = "occupation requerido")
    private String occupation;
    @NotEmpty(message = "signature requerido")
    private String signature;
}
