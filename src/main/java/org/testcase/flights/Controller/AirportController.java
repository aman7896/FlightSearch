package org.testcase.flights.Controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Service.AirportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/getall")
    public ResponseEntity<String> getAll(){
        List<JSONObject> returnAirports = new ArrayList<JSONObject>();
        List<Airport> airports = airportService.getAllAirports();
        returnAirports = airports.stream().map(airport -> {
            JSONObject airportObj = new JSONObject();
            airportObj.put("id",airport.getId()).put("code",airport.getCode());
            JSONArray links = new JSONArray();

            links.put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","airport/getbyid/"+airport.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","airport/create"));

            airportObj.put("links", links);

            return airportObj;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(returnAirports.toString());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<String> getFlightById(@PathVariable int id){
        Optional<Airport> airport = airportService.getAirportById(id);
        JSONObject airportObject = new JSONObject();
        JSONArray links = new JSONArray();

        if(airport.isPresent()){
            airportObject.put("id",airport.get().getId()).put("code",airport.get().getCode());

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","airport/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","airport/getbyid/"+airport.get().getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","airport/create"));

            airportObject.put("links", links);
        }
        else{
            airportObject.put("Message","Airport not found");
            links.put(new JSONObject().put("linkRel","linkrels/getall")
                    .put("uri","airport/getall"));
            airportObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(airportObject.toString());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createFlight(@RequestBody Airport airport){
        JSONObject airportObject = new JSONObject();
        JSONArray links = new JSONArray();
        if(airportService.createAirport(airport)){
            airportObject.put("Message","Airport created successfully");

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","airport/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","airport/getbyid/"+airport.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","airport/create"));

            airportObject.put("links", links);
            airportObject.put("links",links);
        }
        else{
            airportObject.put("Message","Airport could not be created");
            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","airport/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","airport/create"));
            airportObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(airportObject.toString());
    }
}
