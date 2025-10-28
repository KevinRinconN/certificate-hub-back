package com.bovintech.versionone.application.user.query;

import com.bovintech.versionone.application.user.mapper.UserMapper;
import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;

import com.bovintech.versionone.domain.user.model.GetUserDto;
import com.bovintech.versionone.domain.user.model.UserSearchParams;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSearchService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<GetUserDto> execute(UserSearchParams userSearchParams) {
        Page<User> user = userRepository.getAll(userSearchParams);

        return user.map(userMapper::toShow);
    }
}