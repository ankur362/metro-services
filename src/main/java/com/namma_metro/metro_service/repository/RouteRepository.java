package com.namma_metro.metro_service.repository;

import com.namma_metro.metro_service.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {
    Optional<Route> findByStartStationIdAndEndStationId(UUID startStationId, UUID endStationId);

}
