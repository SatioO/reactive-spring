package com.we3.cricpay.models.mappers;

import com.we3.cricpay.models.dtos.LeagueDto;
import com.we3.cricpay.models.entities.League;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeagueMapper extends EntityMapper<League, LeagueDto> {
    LeagueDto toDto(League league);

    League toEntity(LeagueDto league);
}
