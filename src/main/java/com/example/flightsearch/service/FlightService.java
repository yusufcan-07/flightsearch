package com.example.flightsearch.service;

import com.example.flightsearch.entity.Flight;
import com.example.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Read
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Update
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Delete
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime departureTime, LocalDateTime returnTime) {
        if (returnTime == null) {
            // single direction
            return flightRepository.findFlights(departureCity, arrivalCity, departureTime);
        } else {
            // round direction
            return flightRepository.findRoundTripFlights(departureCity, arrivalCity, departureTime, returnTime);
        }
    }

}
