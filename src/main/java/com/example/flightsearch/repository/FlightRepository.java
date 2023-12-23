package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE (:departureCity IS NULL OR f.departureAirport.city = :departureCity) AND (:arrivalCity IS NULL OR f.arrivalAirport.city = :arrivalCity) AND (:departureTime IS NULL OR f.departureTime = :departureTime)")
    List<Flight> findByDepartureAndArrival(String departureCity, String arrivalCity, LocalDateTime departureTime);
}