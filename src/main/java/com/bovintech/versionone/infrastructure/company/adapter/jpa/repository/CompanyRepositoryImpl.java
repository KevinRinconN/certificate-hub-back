package com.bovintech.versionone.infrastructure.company.adapter.jpa.repository;

import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.quey.CompanySearchParams;
import com.bovintech.versionone.domain.company.port.repository.ICompanyRepository;
import com.bovintech.versionone.infrastructure.company.adapter.jpa.ICompanyJpaRepository;
import com.bovintech.versionone.infrastructure.company.adapter.mapper.CompanyMapper;
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

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements ICompanyRepository {

    private final ICompanyJpaRepository iCompanyJpaRepository;
    private final CompanyMapper companyMapper;
    @Override
    public Optional<CompanyDTO> findByNit(String nit) {
        return iCompanyJpaRepository.findByNit(nit).map(companyMapper::toDomain);
    }

    @Override
    public Optional<CompanyDTO> findById(Long id) {
        return iCompanyJpaRepository.findById(id).map(companyMapper::toDomain);
    }

    @Override
    public Optional<CompanyDTO> findByName(String name) {
        return iCompanyJpaRepository.findByName(name).map(companyMapper::toDomain);
    }

    @Override
    public Page<CompanyDTO> search(CompanySearchParams params) {
        Specification<CompanyEntity> specification = new SpecificationBuilder<CompanyEntity>()
                .with(params.getName(), "name", ComparisonType.LIKE)
                .with(params.getNit(), "nit", ComparisonType.LIKE)
                .with(params.getAddress(), "address", ComparisonType.LIKE)
                .with(params.getEmail(), "email", ComparisonType.LIKE)
                .with(params.getPhone(), "phone", ComparisonType.LIKE)
                .with(params.getCiu(), "ciu", ComparisonType.LIKE)
                .build();

        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), SortUtils.createSort(params.getSort()));

        Page<CompanyEntity> companies = iCompanyJpaRepository.findAll(specification, pageable);
        return companies.map(companyMapper::toDomain);
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        return companyMapper.toDomain(iCompanyJpaRepository.save(companyMapper.toDbo(companyDTO)));
    }


}
