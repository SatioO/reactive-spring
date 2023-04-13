package com.we3.cricpay.controllers;

import com.we3.cricpay.models.dtos.CreateLeagueDto;
import com.we3.cricpay.models.dtos.LeagueDto;
import com.we3.cricpay.models.dtos.UpdateLeagueDto;
import com.we3.cricpay.service.LeagueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/leagues")
public class LeagueController {
    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public ResponseEntity<Flux<LeagueDto>> getLeagues() {
        Flux<LeagueDto> foundLeagues = this.leagueService.getLeagues();
        return new ResponseEntity<>(foundLeagues, HttpStatus.OK);
    }

    @GetMapping(path = "/{leagueId}")
    public ResponseEntity<Mono<LeagueDto>> getLeagueByID(@PathVariable() Integer leagueId) {
        Mono<LeagueDto> foundLeague = this.leagueService.getLeagueByID(leagueId);
        return new ResponseEntity<>(foundLeague, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<LeagueDto>> createLeague(@RequestBody() CreateLeagueDto body) {
        Mono<LeagueDto> createdLeague = this.leagueService.createLeague(body);
        return new ResponseEntity<>(createdLeague, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{leagueId}")
    public ResponseEntity<Mono<LeagueDto>> updateLeague(@PathVariable() Integer leagueId, @RequestBody() UpdateLeagueDto body) {
        Mono<LeagueDto> updatedLeague = this.leagueService.updateLeague(leagueId, body);
        return new ResponseEntity<>(updatedLeague, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{leagueId}")
    public ResponseEntity<Mono<LeagueDto>> deleteLeague(@PathVariable() Integer leagueId) {
        Mono<LeagueDto> deleteLeague = this.leagueService.deleteLeague(leagueId);
        return new ResponseEntity<>(deleteLeague, HttpStatus.OK);
    }
}
