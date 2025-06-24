package com.bovintech.versionone.domain.certification.model;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@AtLeastOneField(fields = {"date", "validateBy", "seasonId", "inspectorId", "nameCompany", "email", "phone"}, message = "Debe especificar al menos uno de los campos: date, validateBy, seasonId, o inspectorId")
public class CertificationUpdateDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Min(value = 1, message = "El valor de clientConsecutive debe ser mayor que 0")
    private Long clientConsecutive;

    @Min(value = 1, message = "El valor de validateBy debe ser mayor que 0")
    private Integer validateBy;


    @Size(min = 1, message = "nameCompany no puede estar vacío si se proporciona")
    private String nameCompany;

    @Email(message = "Correo electrónico no es válido")
    private String email;

    @Min(value = 1, message = "El valor de seasonId debe ser mayor que 0")
    private String phone;

    @Min(value = 1, message = "El valor de seasonId debe ser mayor que 0")
    private Long seasonId;


    @Size(min = 1, message = "inspectorId no puede estar vacío si se proporciona")
    private String inspectorId;
}
