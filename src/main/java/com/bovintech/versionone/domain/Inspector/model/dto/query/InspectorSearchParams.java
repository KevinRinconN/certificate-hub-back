package com.bovintech.versionone.domain.Inspector.model.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InspectorSearchParams {
    private String firstname;
    private String lastname;
    private String occupation;
}
