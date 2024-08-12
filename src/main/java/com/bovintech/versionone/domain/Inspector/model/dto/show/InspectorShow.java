package com.bovintech.versionone.domain.Inspector.model.dto.show;

import lombok.Data;

@Data
public class InspectorShow {
    private Long id;
    private String firstname;
    private String lastname;
    private String displayName;
    private String occupation;
    private String signature;
}
