package com.namma_metro.metro_service.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    private UUID stationId;
    private Timestamp checkInTime;
}