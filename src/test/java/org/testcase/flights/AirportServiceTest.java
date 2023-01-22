package org.testcase.flights;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Service.AirportService;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AirportServiceTest {
    @Autowired
    private AirportService airportService;

    @Test
    public void getAirporttByIdTest(){
        Airport airport = new Airport(1,"DEL");
        Optional<Flight> searched = airportService.getAirportById(1);
        assertEquals(airport.toString(),searched.orElse(null).toString());
    }
    @Test
    public void createFlightTest(){
        Airport airport = new Airport(1,"DEL");
        assertEquals(true,airportService.createAirport(airport));
    }
    @Test
    public void updateFlightTest(){
        Airport airport = new Airport(1,"CDG");
        assertEquals(true,airportService.updateAirport(airport));
    }
    @Test
    public void deleteFlightTest(){
        Airport airport = new Airport(1,"CDG");
        assertEquals(true,airport.deleteAirport(airport));
    }
}
