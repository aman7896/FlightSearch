package org.testcase.flights.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;
import org.testcase.flights.Repos.FlightRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    Logger logger = LoggerFactory.getLogger(FlightService.class);

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(int id){
        return flightRepository.findById(id);
    }

    public boolean createFlight(Flight flight){
        try{
            flightRepository.save(flight);
            return true;
        }
        catch (Exception e){
            logger.error("Exception occured while creating flight", e);
        }
        return false;
    }

    public boolean updateFlight(Flight flight){
        try{
            flightRepository.save(flight);
            return true;
        }
        catch (Exception e){
            logger.error("Exception occured while updating flight", e);
        }
        return false;
    }

    public boolean deleteFlight(Flight flight){
        try{
            flightRepository.delete(flight);
            return true;
        }
        catch (Exception e){
            logger.error("Exception occured while deleting flight", e);
        }
        return false;
    }

    public Optional<Flight> getFlightByNumber(String flightnumber){
        return flightRepository.findByFlightNumber(flightnumber);
    }

    public List<Flight> getFlightByOrigDest(Airport origin, Airport destination){
        return flightRepository.findByOriginAndDestination(origin, destination);
    }
}
