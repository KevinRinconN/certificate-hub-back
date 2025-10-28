package com.bovintech.versionone.domain.user.model;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetUserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Rol rol;
}
