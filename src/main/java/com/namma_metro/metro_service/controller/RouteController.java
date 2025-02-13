package com.namma_metro.metro_service.controller;

import com.namma_metro.metro_service.dto.ApiResponse;
import com.namma_metro.metro_service.model.Route;
import com.namma_metro.metro_service.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addRoute(@RequestBody Route route) {
        try {
            Route savedRoute = routeService.addRoute(route);
            return ResponseEntity.ok(new ApiResponse("Route added successfully", savedRoute));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return ResponseEntity.ok(new ApiResponse("Routes retrieved successfully", routes));
    }
}