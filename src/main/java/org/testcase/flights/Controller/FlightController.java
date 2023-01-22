package org.testcase.flights.Controller;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;
import org.testcase.flights.Service.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/getall")
    public ResponseEntity<String> getAllFlights(){
        List<JSONObject> returnFlights = new ArrayList<JSONObject>();
        List<Flight> flights = flightService.getAllFlights();
        returnFlights = flights.stream().map(flight -> {
            JSONObject flightObject = new JSONObject();
            JSONObject origin = new JSONObject();
            JSONObject destination = new JSONObject();

            flightObject.put("id",flight.getId());
            flightObject.put("flightNumber",flight.getFlightNumber());

            origin.put("id",flight.getOrigin().getId());
            origin.put("code",flight.getOrigin().getCode());
            flightObject.put("origin", origin);

            destination.put("id",flight.getDestination().getId());
            destination.put("code",flight.getDestination().getCode());
            flightObject.put("destination", destination);

            flightObject.put("duration",flight.getDuration());

            JSONArray links = new JSONArray();
            JSONObject link = new JSONObject();

            links.put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest/origin/destination")
                            .put("uri","flights/getflightbyorigdest/"+flight.getOrigin().getCode()+"/"+flight.getDestination().getCode()));

            flightObject.put("links", links);

            return flightObject;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(returnFlights.toString());
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
