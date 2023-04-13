package com.we3.cricpay.repositories;

import com.we3.cricpay.models.entities.League;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LeagueRepository extends ReactiveCrudRepository<League, Integer> {
}
