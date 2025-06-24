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

    private String name;

    @NotNull(message = "Consecutivo de cliente requerido")
    @Min(value = 1, message = "El valor de clientConsecutive debe ser mayor que 0")
    private Long clientConsecutive;

    @NotEmpty(message = "CIIU requerido")
    private String ciu;

    @NotNull(message = "Fecha requerida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;

    @NotNull(message = "validateBy requerido")
    @Min(value = 1, message = "El valor de validateBy debe ser mayor que 0")
    private Integer validateBy;

    @Email(message = "Correo electrónico no es válido")
    private String email;

    private String phone;

    @NotEmpty(message = "Dirección requerida")
    private String address;

    @NotEmpty(message = "ID de temporada requerido")
    private String seasonId;

    @NotEmpty(message = "ID de inspector requerido")
    private String inspectorId;


    public void setEmail(String email) {
        this.email = email != null ? email.trim() : null;
    }

}