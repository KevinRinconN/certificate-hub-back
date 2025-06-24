package com.bovintech.versionone.domain.departament.model.dto;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import lombok.Data;

@Data
@AtLeastOneField(fields = {"coordinatorName", "coordinatorOccupation", "coordinatorSign"}, message = "Debe especificar al menos uno de los campos: coordinatorName, coordinatorOccupation o coordinatorSign")
public class DepartmentUpdateDTO {
    private String coordinatorName;
    private String coordinatorOccupation;
    private String coordinatorSign;
}
