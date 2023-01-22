package org.testcase.flights;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Service.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AirportServiceTest {
    @Autowired
    private FlightService flightService;

    @Test
    public void getFlightByIdTest(){
        Flight flight = new Flight(1,"IND0001", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        Optional<Flight> searched = flightService.getFlightById(1);
        assertEquals(flight.toString(),searched.orElse(null).toString());
    }
    @Test
    public void createFlightTest(){
        Flight flight = new Flight( 20,"KLM0007", new Airport(4,"JFK"), new Airport(5 , "AMS"), 27000000);
        assertEquals(true,flightService.createFlight(flight));
    }
    @Test
    public void updateFlightTest(){
        Flight flight = new Flight(1,"IND0999", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        assertEquals(true,flightService.updateFlight(flight));
    }
    @Test
    public void deleteFlightTest(){
        Flight flight = new Flight(1,"IND0001", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        assertEquals(true,flightService.deleteFlight(flight));
    }
    @Test
    public void getFlightByNumberTest(){
        Flight flight = new Flight(2,"IND0002", new Airport(2,"BLR"), new Airport(1 , "DEL"), 9000000);
        Optional<Flight> searched = flightService.getFlightByNumber("IND0002");
        assertEquals(flight.toString(),searched.orElse(null).toString());
    }
    @Test
    public void getFlightByOrigDestTest(){
        Flight flight = new Flight(2,"IND0002", new Airport(2,"BLR"), new Airport(1 , "DEL"), 9000000);
        List<Flight> flightList = new ArrayList<Flight>();
        flightList.add(flight);
        assertEquals(flightList.toString(),flightService.getFlightByOrigDest(new Airport(2,"BLR"),new Airport(1,"DEL")).toString());
    }
}
