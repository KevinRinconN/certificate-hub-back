package com.bovintech.versionone.application.auth.mapper;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.infrastructure.auth.adapter.model.response.UserRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserRestMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "rol", target = "rol")
    UserRest toRest(User domain);
}
