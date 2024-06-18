package com.stackoverflow.flights.controller;

import com.stackoverflow.flights.entity.Flight;
import com.stackoverflow.flights.model.ObjectResponse;
import com.stackoverflow.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/find-flights/{originAirport}/{destinationAirport}/{departureDate}")
    public ResponseEntity<ObjectResponse> findFlights(@PathVariable String originAirport, @PathVariable String destinationAirport, @PathVariable String departureDate) {
        System.out.println("Searching flights with origin: " + originAirport + ", destination: " + destinationAirport);

        ObjectResponse resp = new ObjectResponse();

        try{
            List<Flight> flights = flightService.findFlightsByAirport(originAirport, destinationAirport);
            if (flights.isEmpty()) {
                resp.setMessage("No Flights Found");
                resp.setMessageType("error");
                resp.setStatusCode(HttpStatus.OK);
            } else {
                resp.setResponseData(flights);
                resp.setStatusCode(HttpStatus.OK);
                resp.setMessage("Flights Found");
                resp.setMessageType("success");
            }
        }catch (Exception ex){
            resp.setStatusCode(HttpStatus.BAD_REQUEST);
            resp.setMessage("Error occurred on the server");
            resp.setMessageType("error");
            ex.printStackTrace();
        }

        return new ResponseEntity<>(resp, resp.getStatusCode());
    }

}