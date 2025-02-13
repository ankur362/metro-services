package com.namma_metro.metro_service.service;

import com.namma_metro.metro_service.model.Station;
import com.namma_metro.metro_service.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station addStation(Station station) {
        return stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
    public void deleteStation(UUID stationId) {
        if (!stationRepository.existsById(stationId)) {
            throw new IllegalArgumentException("Station not found");
        }
        stationRepository.deleteById(stationId);
    }
}