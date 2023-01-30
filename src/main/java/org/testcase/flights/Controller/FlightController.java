package org.testcase.flights.Controller;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;
import org.testcase.flights.Service.FlightService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        returnFlights = flights.stream().sorted((Comparator.comparing(Flight::getDuration)))
            .map(flight -> {
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

                flightObject.put("duration", Duration.ofMillis(flight.getDuration()).toString().substring(2));

                JSONArray links = new JSONArray();

                links.put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                        .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                        .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                        .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                        .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                        .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                                .put("uri","flights/getflightbyorigdest"));

                flightObject.put("links", links);

                return flightObject;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(returnFlights.toString());
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<String> getFlightById(@PathVariable int id){
        Optional<Flight> flight = flightService.getFlightById(id);
        JSONObject flightObject = new JSONObject();
        JSONArray links = new JSONArray();

        if(flight.isPresent()){
            JSONObject origin = new JSONObject();
            JSONObject destination = new JSONObject();

            flightObject.put("id",flight.get().getId());
            flightObject.put("flightNumber",flight.get().getFlightNumber());

            origin.put("id",flight.get().getOrigin().getId());
            origin.put("code",flight.get().getOrigin().getCode());
            flightObject.put("origin", origin);

            destination.put("id",flight.get().getDestination().getId());
            destination.put("code",flight.get().getDestination().getCode());
            flightObject.put("destination", destination);

            flightObject.put("duration",Duration.ofMillis(flight.get().getDuration()).toString().substring(2));

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.get().getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.get().getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                            .put("uri","flights/getflightbyorigdest"));

            flightObject.put("links", links);
        }
        else{
            flightObject.put("Message","Flight not found");
            links.put(new JSONObject().put("linkRel","linkrels/getall")
                            .put("uri","flights/getall"));
            flightObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(flightObject.toString());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createFlight(@RequestBody Flight flight){
        JSONObject flightObject = new JSONObject();
        JSONArray links = new JSONArray();
        if(flightService.createFlight(flight)){
            flightObject.put("Message","Flight created successfully");

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                            .put("uri","flights/getflightbyorigdest"));
            flightObject.put("links",links);
        }
        else{
            flightObject.put("Message","Flight could not be created");
            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"));
            flightObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(flightObject.toString());
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateFlight(@RequestBody Flight flight){
        JSONObject flightObject = new JSONObject();
        JSONArray links = new JSONArray();
        if(flightService.updateFlight(flight)){
            flightObject.put("Message","Flight updated successfully");

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                            .put("uri","flights/getflightbyorigdest"));
            flightObject.put("links",links);
        }
        else{
            flightObject.put("Message","Flight could not be updated");
            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"));
            flightObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(flightObject.toString());
    }
    @PostMapping("/delete")
    public ResponseEntity<String> deleteFlight(@RequestBody Flight flight){
        JSONObject flightObject = new JSONObject();
        JSONArray links = new JSONArray();
        if(flightService.deleteFlight(flight)){
            flightObject.put("Message","Flight deleted successfully");

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                            .put("uri","flights/getflightbyorigdest"));
            flightObject.put("links",links);
        }
        else{
            flightObject.put("Message","Flight could not be deleted");
            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"));
            flightObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(flightObject.toString());
    }
    @GetMapping("/getflightbynumber/{flightnumber}")
    public ResponseEntity<String> getFlightByNumber(@PathVariable String flightnumber){
        Optional<Flight> flight = flightService.getFlightByNumber(flightnumber);
        JSONObject flightObject = new JSONObject();
        JSONArray links = new JSONArray();

        if(flight.isPresent()){
            JSONObject origin = new JSONObject();
            JSONObject destination = new JSONObject();

            flightObject.put("id",flight.get().getId());
            flightObject.put("flightNumber",flight.get().getFlightNumber());

            origin.put("id",flight.get().getOrigin().getId());
            origin.put("code",flight.get().getOrigin().getCode());
            flightObject.put("origin", origin);

            destination.put("id",flight.get().getDestination().getId());
            destination.put("code",flight.get().getDestination().getCode());
            flightObject.put("destination", destination);

            flightObject.put("duration",Duration.ofMillis(flight.get().getDuration()).toString().substring(2));

            links.put(new JSONObject().put("linkRel","linkrels/getall").put("uri","flights/getall"))
                    .put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.get().getId()))
                    .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                    .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.get().getFlightNumber()))
                    .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                    .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                            .put("uri","flights/getflightbyorigdest"));

            flightObject.put("links", links);
        }
        else{
            flightObject.put("Message","Flight not found");
            links.put(new JSONObject().put("linkRel","linkrels/getall")
                    .put("uri","flights/getall"));
            flightObject.put("links",links);
        }
        return ResponseEntity.status(HttpStatus.OK).body(flightObject.toString());
    }
    @PostMapping("/getflightbyorigdest")
    public ResponseEntity<String> getFlightByOrigDest(@RequestBody String origdest){
        JSONObject obj = new JSONObject(origdest);
        Airport origin = new Airport((JSONObject) obj.get("origin"));
        Airport destination = new Airport((JSONObject) obj.get("destination"));
        List<JSONObject> returnFlights = new ArrayList<JSONObject>();
        List<Flight> flights = flightService.getFlightByOrigDest(origin,destination);
        returnFlights = flights.stream().sorted((Comparator.comparing(Flight::getDuration)))
            .map(flight -> {
                JSONObject flightObject = new JSONObject();
                JSONObject orig = new JSONObject();
                JSONObject dest = new JSONObject();

                flightObject.put("id",flight.getId());
                flightObject.put("flightNumber",flight.getFlightNumber());

                orig.put("id",flight.getOrigin().getId());
                orig.put("code",flight.getOrigin().getCode());
                flightObject.put("origin", orig);

                dest.put("id",flight.getDestination().getId());
                dest.put("code",flight.getDestination().getCode());
                flightObject.put("destination", dest);

                flightObject.put("duration",Duration.ofMillis(flight.getDuration()).toString().substring(2));

                JSONArray links = new JSONArray();

                links.put(new JSONObject().put("linkRel","linkrels/getbyid/id").put("uri","flights/getbyid/"+flight.getId()))
                        .put(new JSONObject().put("linkRel","linkrels/create").put("uri","flights/create"))
                        .put(new JSONObject().put("linkRel","linkrels/update").put("uri","flights/update"))
                        .put(new JSONObject().put("linkRel","linkrels/getflightbynumber/flightnumber").put("uri","flights/getflightbynumber/"+flight.getFlightNumber()))
                        .put(new JSONObject().put("linkRel","linkrels/delete").put("uri","flights/delete"))
                        .put(new JSONObject().put("linkRel","linkrels/getflightbyorigdest")
                                .put("uri","flights/getflightbyorigdest"));

                flightObject.put("links", links);

                return flightObject;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(returnFlights.toString());
    }
}
