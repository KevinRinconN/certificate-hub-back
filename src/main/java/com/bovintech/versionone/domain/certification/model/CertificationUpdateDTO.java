package com.bovintech.versionone.domain.certification.model;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@AtLeastOneField(fields = {"date", "validateBy", "seasonId", "inspectorId"}, message = "Debe especificar al menos uno de los campos: date, validateBy, seasonId, o inspectorId")
public class CertificationUpdateDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Min(value = 1, message = "El valor de validateBy debe ser mayor que 0")
    private Integer validateBy;

    @Min(value = 1, message = "El valor de seasonId debe ser mayor que 0")
    private Long seasonId;

    @Min(value = 1, message = "El valor de seasonId debe ser mayor que 0")
    private Long inspectorId;
}
