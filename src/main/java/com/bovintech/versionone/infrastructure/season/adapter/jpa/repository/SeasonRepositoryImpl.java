package com.bovintech.versionone.infrastructure.season.adapter.jpa.repository;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonSearchParams;
import com.bovintech.versionone.domain.season.port.repository.ISeasonRepository;
import com.bovintech.versionone.infrastructure.season.adapter.jpa.ISeasonJpaRepository;
import com.bovintech.versionone.infrastructure.season.adapter.mapper.SeasonMapper;
import com.bovintech.versionone.infrastructure.season.adapter.model.entity.SeasonEntity;
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
public class SeasonRepositoryImpl implements ISeasonRepository {

    private final ISeasonJpaRepository iSeasonJpaRepository;
    private final SeasonMapper seasonMapper;

    @Override
    public Optional<SeasonDTO> getById(Long id) {
        var optionalSeason = iSeasonJpaRepository.findById(id);

        return optionalSeason.map(seasonMapper::toDomain);
    }

    @Override
    public Page<SeasonDTO> find(SeasonSearchParams params) {
        Specification<SeasonEntity> specification = new SpecificationBuilder<SeasonEntity>()
                .with(params.getName(), "name", ComparisonType.LIKE)
                .build();

        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), SortUtils.createSort(params.getSort()));
        Page<SeasonEntity> entity = iSeasonJpaRepository.findAll(specification, pageable);
        return entity.map(seasonMapper::toDomain);
    }

    @Override
    public SeasonDTO save(SeasonDTO seasonDTO) {
        var seasonToSave = seasonMapper.toDbo(seasonDTO);
        var seasonSaved = iSeasonJpaRepository.save(seasonToSave);
        return seasonMapper.toDomain(seasonSaved);
    }
}
