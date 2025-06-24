package com.bovintech.versionone.domain.season.model;

import com.bovintech.versionone.domain.util.validation.AtLeastOneField;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@AtLeastOneField(fields = {"name", "prefix", "startDate"}, message = "Debe especificar al menos uno de los campos: name, prefix o startDate")
public class SeasonUpdateDTO {

    private String name;
    private String prefix;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
}
