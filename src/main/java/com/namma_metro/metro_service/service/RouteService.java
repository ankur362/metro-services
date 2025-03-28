package com.namma_metro.metro_service.service;

import com.namma_metro.metro_service.model.Route;
import com.namma_metro.metro_service.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route addRoute(Route route) {
        if (route.getStartStationId() == null || route.getEndStationId() == null || route.getFare() == null) {
            throw new IllegalArgumentException("Route must have startStationId, endStationId, and fare");
        }
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    public BigDecimal getFare(UUID startStationId, UUID endStationId) {
        Optional<Route> route = routeRepository.findByStartStationIdAndEndStationId(startStationId, endStationId);

        if (route.isEmpty()) {
            throw new RuntimeException("Route not found");
        }

        return route.get().getFare();
    }
}