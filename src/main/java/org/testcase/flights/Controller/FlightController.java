package org.testcase.flights.Controller;

import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @GetMapping("/getall")
    public JSONArray getAllFlights(){
        return null;
    }
    @GetMapping("/getbyid/{id}")
    public JSONObject getFlightById(@PathVariable int id){
        return null;
    }
    @PostMapping("/create")
    public JSONObject createFlight(Flight flight){
        return null;
    }
    @PostMapping("/update")
    public JSONObject updateFlight(Flight flight){
        return null;
    }
    @PostMapping("/delete")
    public JSONObject deleteFlight(Flight flight){
        return null;
    }
    @GetMapping("/getflightbynumber/{flightnumber}")
    public JSONObject getFlightByNumber(@PathVariable String flightnumber){
        return null;
    }
    @GetMapping("/getflightbyorigdest/{origin}/{destination}")
    public JSONObject getFlightByOrigDest(@PathVariable String origin, @PathVariable String destination){
        return null;
    }
}
