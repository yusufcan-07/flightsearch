package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE (:departureCity IS NULL OR f.departureAirport.city = :departureCity) AND (:arrivalCity IS NULL OR f.arrivalAirport.city = :arrivalCity) AND (:departureTime IS NULL OR f.departureTime = :departureTime)")
    List<Flight> findFlights(@Param("departureCity") String departureCity, @Param("arrivalCity") String arrivalCity, @Param("departureTime") LocalDateTime departureTime);

    @Query("SELECT f FROM Flight f WHERE ((:departureCity IS NULL OR f.departureAirport.city = :departureCity) AND (:arrivalCity IS NULL OR f.arrivalAirport.city = :arrivalCity) AND (:departureTime IS NULL OR f.departureTime = :departureTime)) OR ((:arrivalCity IS NULL OR f.departureAirport.city = :arrivalCity) AND (:departureCity IS NULL OR f.arrivalAirport.city = :departureCity) AND (:returnTime IS NULL OR f.returnTime = :returnTime))")
    List<Flight> findRoundTripFlights(String departureCity, String arrivalCity, LocalDateTime departureTime, LocalDateTime returnTime);
}