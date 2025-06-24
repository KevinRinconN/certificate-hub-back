package com.bovintech.versionone.domain.departament.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartamentDTO {
    private Long id;
    private String coordinatorName;
    private String coordinatorOccupation;
    private String coordinatorSign;
}
