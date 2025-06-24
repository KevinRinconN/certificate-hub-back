package com.bovintech.versionone.infrastructure.departament.adapter.jpa.repository;

import com.bovintech.versionone.domain.departament.model.dto.DepartamentDTO;
import com.bovintech.versionone.domain.departament.port.repository.IDepartamentRepository;
import com.bovintech.versionone.infrastructure.departament.adapter.jpa.IDepartamentJpaRepository;
import com.bovintech.versionone.infrastructure.departament.adapter.mapper.DepartmentMapper;
import com.bovintech.versionone.infrastructure.departament.adapter.model.entity.DepartamentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartamentRepositoryImpl implements IDepartamentRepository {
    private final IDepartamentJpaRepository iDepartamentJpaRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public Optional<DepartamentDTO> findDepartament() {
        Optional<DepartamentEntity> entity = iDepartamentJpaRepository.findFirstByOrderByIdAsc();
        return entity.map(departmentMapper::toDomain);
    }

    @Override
    public DepartamentDTO save(DepartamentDTO dto) {
        var departmentToSave = departmentMapper.toDbo(dto);
        var departmentSaved = iDepartamentJpaRepository.save(departmentToSave);
        return departmentMapper.toDomain(departmentSaved);
    }
}
