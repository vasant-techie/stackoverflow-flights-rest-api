package com.stackoverflow.flights.service;

import com.stackoverflow.flights.entity.Flight;
import com.stackoverflow.flights.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void saveFlight(Flight flight) {
        flightRepository.saveAndFlush(flight);
    }

    public List<Flight> findFlightsByAirport(String originAirport, String destinationAirport) {
        return flightRepository.findByOriginAirportAndDestinationAirport(originAirport, destinationAirport);
    }
}
