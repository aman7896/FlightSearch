import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Service.FlightService;

@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @Test
    public void getFlightByIdTest(){
        Flight flight = new Flight(1,"IND0001", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        assertEquals(flight,flightService.getFlightById(1));
    }
    @Test
    public void createFlightTest(){
        Flight flight = new Flight(13,"KLM0007", new Airport(4,"JFK"), new Airport(5 , "AMS"), 27000000);
        assertEquals(true,flightService.createFlight(flight));
    }
    @Test
    public void updateFlightTest(){
        Flight flight = new Flight(1,"IND0999", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        assertEquals(true,flightService.createFlight(flight));
    }
    @Test
    public void deleteFlightTest(){
        Flight flight = new Flight(1,"IND0001", new Airport(1,"DEL"), new Airport(2 , "BLR"), 9000000);
        assertEquals(flight,flightService.deleteFlight(flight));
    }
    @Test
    public void getFlightByNumberTest(){
        Flight flight = new Flight(2,"IND0002", new Airport(2,"BLR"), new Airport(1 , "DEL"), 9000000);
        assertEquals(flight,flightService.getFlightByNumber("IND0002"));
    }
    @Test
    public void getFlightByOrigDestTest(){
        Flight flight = new Flight(2,"IND0002", new Airport(2,"BLR"), new Airport(1 , "DEL"), 9000000);
        assertEquals(flight,flightService.getFlightByOrigDest("BLR","DEL"));
    }
}
