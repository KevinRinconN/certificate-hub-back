package com.bovintech.versionone.domain.user.model;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import lombok.Data;
@Data
public class UpdateUserDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Rol rol;
    private Boolean locked;
    private Boolean disabled;
}
