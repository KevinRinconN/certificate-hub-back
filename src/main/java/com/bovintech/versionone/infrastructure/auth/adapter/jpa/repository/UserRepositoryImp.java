package com.bovintech.versionone.infrastructure.auth.adapter.jpa.repository;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.user.model.UserSearchParams;
import com.bovintech.versionone.infrastructure.auth.adapter.jpa.UserJpaRepository;
import com.bovintech.versionone.infrastructure.auth.adapter.mapper.UserDboMapper;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.company.adapter.model.entity.CompanyEntity;
import com.bovintech.versionone.infrastructure.util.ComparisonType;
import com.bovintech.versionone.infrastructure.util.SpecificationBuilder;
import com.bovintech.versionone.infrastructure.util.pagination.SortUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImp implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserDboMapper userDboMapper;

    @Override
    public Optional<User> getById(String username) {
        var optionalUser = userJpaRepository.findById(username);

        return optionalUser.map(userDboMapper::toDomain);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        var optionalUser = userJpaRepository.findByEmail(email);

        return optionalUser.map(userDboMapper::toDomain);
    }

    @Override
    public Page<User> getAll(UserSearchParams params) {
        Specification<UserEntity> specification = new SpecificationBuilder<UserEntity>()
                .with(params.getFirstnames(), "firstName", ComparisonType.LIKE)
                .with(params.getLastnames(), "lastName", ComparisonType.LIKE)
                .with(params.getEmail(), "email", ComparisonType.LIKE).build();
        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), SortUtils.createSort(params.getSort()));
        Page<UserEntity> entity = userJpaRepository.findAll(specification, pageable);
        return entity.map(userDboMapper::toDomain);
    }

    @Override
    public User create(User request) {
        var userToSave = userDboMapper.toDbo(request);
        var userSaved = userJpaRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public void deleteById(Long id) {

    }
    public void delete(User user) {
        var entity = userDboMapper.toDbo(user);
        userJpaRepository.delete(entity);
    }
    @Override
    public User update(User request) {
        var userEntity = userDboMapper.toDbo(request);
        var saved = userJpaRepository.save(userEntity);
        return userDboMapper.toDomain(saved);
    }
}
