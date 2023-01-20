package org.testcase.flights.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;
import java.util.List;
import java.util.Optional;

public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return null;
    }

    public Optional<Flight> getFlightById(int id){
        return null;
    }

    public boolean createFlight(Flight flight){
        return false;
    }

    public boolean updateFlight(Flight flight){
        return false;
    }

    public boolean deleteFlight(Flight flight){
        return false;
    }

    public Optional<Flight> getFlightByNumber(String flightnumber){
        return null;
    }

    public Optional<Flight> getFlightByOrigDest(String origin, String destination){
        return null;
    }
}
