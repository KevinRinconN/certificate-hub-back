package com.bovintech.versionone.domain.season.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SeasonCreateDTO {
    @NotEmpty(message = "name requerido")
    private String name;
    @NotEmpty(message = "prefix requerido")
    private String prefix;
    @NotNull(message = "startDate requerida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
}
