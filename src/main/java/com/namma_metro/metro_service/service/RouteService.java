package com.namma_metro.metro_service.service;

import com.namma_metro.metro_service.model.Route;
import com.namma_metro.metro_service.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}