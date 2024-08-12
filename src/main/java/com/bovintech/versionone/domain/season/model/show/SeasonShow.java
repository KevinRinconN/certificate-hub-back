package com.bovintech.versionone.domain.season.model.show;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeasonShow {
    private Long id;
    private String name;
    private LocalDate startDate;
}
