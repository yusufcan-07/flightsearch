package com.example.flightsearch.scheduler;

import com.example.flightsearch.entity.Airport;
import com.example.flightsearch.entity.Flight;
import com.example.flightsearch.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightInfoScheduler {

    @Autowired
    private FlightService flightService;

    @Scheduled(cron = "0 0 0 * * *", zone = "UTC")
    public void updateFlightInfo() {
        List<Flight> flights = fetchFlightsFromMockApi();
        flights.forEach(flightService::createFlight);
    }

    private List<Flight> fetchFlightsFromMockApi() {
        List<Flight> mockFlights = new ArrayList<>();

        mockFlights.add(createMockFlight("İstanbul", "Ankara"));
        mockFlights.add(createMockFlight("Ankara", "İzmir"));
        mockFlights.add(createMockFlight("İzmir", "İstanbul"));

        return mockFlights;
    }

    private Flight createMockFlight(String departureCity, String arrivalCity) {
        Flight flight = new Flight();
        flight.setDepartureAirport(createMockAirport(departureCity));
        flight.setArrivalAirport(createMockAirport(arrivalCity));
        flight.setDepartureTime(LocalDateTime.now().plusDays(1));
        flight.setReturnTime(LocalDateTime.now().plusDays(1).plusHours(2));
        flight.setPrice(100.0);

        return flight;
    }

    private Airport createMockAirport(String city) {
        Airport airport = new Airport();
        airport.setCity(city);
        return airport;
    }
}
