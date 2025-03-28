package com.namma_metro.metro_service.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    private UUID stationId;
    private Timestamp checkOutTime;
    private BigDecimal fare;
    private String paymentMethod;
    private BigDecimal surcharge;
    private BigDecimal totalAmount;
    private Boolean paid;
}