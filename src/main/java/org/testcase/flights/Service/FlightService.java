package org.testcase.flights.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;

public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public JSONArray getAllFlights(){
        return null;
    }

    public JSONObject getFlightById( int id){
        return null;
    }

    public JSONObject createFlight(Flight flight){
        return null;
    }

    public JSONObject updateFlight(Flight flight){
        return null;
    }

    public JSONObject deleteFlight(Flight flight){
        return null;
    }

    public JSONObject getFlightByNumber(String flightnumber){
        return null;
    }

    public JSONObject getFlightByOrigDest(String origin, String destination){
        return null;
    }
}
