package com.bovintech.versionone.domain.season.mapper;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.SeasonUpdateDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SeasonMapper {
    SeasonMapper INSTANCE = Mappers.getMapper( SeasonMapper.class );
    SeasonShow toShow(SeasonDTO dto);

    void toUpdateFromDto (SeasonUpdateDTO updateDTO, @MappingTarget SeasonDTO dto);
}
