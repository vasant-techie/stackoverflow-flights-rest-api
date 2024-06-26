package com.stackoverflow.flights.repo;

import com.stackoverflow.flights.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByOriginAirportAndDestinationAirport(String originAirport, String destinationAirport);

}
