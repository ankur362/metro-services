package com.namma_metro.metro_service.repository;

import com.namma_metro.metro_service.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StationRepository extends JpaRepository<Station, UUID> {
}