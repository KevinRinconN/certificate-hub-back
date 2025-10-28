package com.bovintech.versionone.domain.auth.port.repository;


import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.user.model.UserSearchParams;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getById(String username);
    Optional<User> getByEmail(String email);
    Page<User> getAll(UserSearchParams params);
    User create(User request);
    void deleteById(Long id);
    void delete(User user);
    User update(User request);
}
