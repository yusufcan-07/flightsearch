package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Burada özel sorgu metodları ekleyebilirsiniz
}