package com.bovintech.versionone.application.user.mapper;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.user.model.GetUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface UserMapper {

    GetUserDto toShow (User user);
}
