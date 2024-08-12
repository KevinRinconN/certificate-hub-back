package com.bovintech.versionone.domain.season.mapper;

import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.model.show.SeasonShow;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SeasonMapper {
    SeasonMapper INSTANCE = Mappers.getMapper( SeasonMapper.class );
    SeasonShow toShow(SeasonDTO dto);
}
