package com.bovintech.versionone.domain.certification.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateCertificationDTO {
    @NotEmpty(message = "NIT requerido")
    private String nit;

    @NotEmpty(message = "Nombre requerido")
    private String name;

    @NotEmpty(message = "CIU requerido")
    private String ciu;

    @NotNull(message = "Fecha requerida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @NotNull(message = "validateBy requerido")
    @Min(value = 1, message = "El valor de validateBy debe ser mayor que 0")
    private Integer validateBy;

    @NotEmpty(message = "Correo electrónico requerido")
    @Email(message = "Correo electrónico no es válido")
    private String email;

    @NotEmpty(message = "Teléfono requerido")
    private String phone;

    @NotEmpty(message = "Dirección requerida")
    private String address;

    @NotEmpty(message = "ID de temporada requerido")
    private String seasonId;

    @NotNull(message = "ID de inspector requerido")
    private Long inspectorId;
}