package com.namma_metro.metro_service.controller;

import com.namma_metro.metro_service.dto.ApiResponse;
import com.namma_metro.metro_service.model.Station;
import com.namma_metro.metro_service.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.Map;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "*")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStation(@org.jetbrains.annotations.NotNull @RequestBody Station station) {
        System.out.println("Received Station Data: " + station.getName() + " - " + station.getEmail()); // Debugging log

        try {
            Station savedStation = stationService.addStation(station);
            return ResponseEntity.ok(new ApiResponse("Station added successfully", savedStation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponse> deleteStation(@RequestBody Map<String, UUID> request) {
        try {
            UUID id = request.get("id");
            stationService.deleteStation(id);
            return ResponseEntity.ok(new ApiResponse("Station deleted successfully", null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), null));
        }
    }
}