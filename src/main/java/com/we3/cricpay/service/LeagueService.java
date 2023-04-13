package com.we3.cricpay.service;

import com.we3.cricpay.models.dtos.CreateLeagueDto;
import com.we3.cricpay.models.dtos.LeagueDto;
import com.we3.cricpay.models.dtos.UpdateLeagueDto;
import com.we3.cricpay.models.mappers.LeagueMapper;
import com.we3.cricpay.repositories.LeagueRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LeagueService {
    private final LeagueRepository leagueRepository;
    private final LeagueMapper leagueMapper;

    public LeagueService(LeagueRepository leagueRepository, LeagueMapper leagueMapper) {
        this.leagueRepository = leagueRepository;
        this.leagueMapper = leagueMapper;
    }

    public Flux<LeagueDto> getLeagues() {
        return this.leagueRepository
                .findAll()
                .map(leagueMapper::toDto);
    }

    public Mono<LeagueDto> getLeagueByID(Integer leagueId) {
        return this.leagueRepository
                .findById(leagueId)
                .map(leagueMapper::toDto);
    }

    public Mono<LeagueDto> createLeague(CreateLeagueDto body) {
        LeagueDto league = new LeagueDto()
                .setName(body.getName())
                .setDescription(body.getDescription())
                .setEnabled(body.isEnabled());

        return this.leagueRepository.save( leagueMapper.toEntity(league)).map(leagueMapper::toDto);
    }

    public Mono<LeagueDto> updateLeague(Integer leagueId, UpdateLeagueDto body) {
        return this.leagueRepository.findById(leagueId).flatMap(existingLeague -> {
            existingLeague.setName(body.getName()).setDescription(body.getDescription()).setEnabled(body.isEnabled());
            return this.leagueRepository.save(existingLeague);
        }).map(leagueMapper::toDto);
    }

    public Mono<LeagueDto> deleteLeague(Integer leagueId) {
        return this.leagueRepository.findById(leagueId)
                .flatMap(existingLeague -> this.leagueRepository.delete(existingLeague)
                        .then(Mono.just(leagueMapper.toDto(existingLeague))));
    }
}
