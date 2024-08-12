package com.bovintech.versionone.domain.Inspector.model.dto;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@AtLeastOneField(fields = {"firstname", "lastname", "displayName", "occupation", "signature"}, message = "Debe especificar al menos uno de los campos: firstname, lastname, displayName, occupation o signature")
public class InspectorUpdateDTO {
    private String firstname;
    private String lastname;
    private String displayName;
    private String occupation;
    private String signature;
}
