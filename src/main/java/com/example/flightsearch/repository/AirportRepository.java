package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    // Burada özel sorgu metodları ekleyebilirsiniz
}