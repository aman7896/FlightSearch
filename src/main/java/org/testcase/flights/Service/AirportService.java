package org.testcase.flights.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Repos.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    Logger logger = LoggerFactory.getLogger(AirportService.class);

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(int id){
        return airportRepository.findById(id);
    }

    public boolean createAirport(Airport airport){
        try{
            airportRepository.save(airport);
            return true;
        }
        catch (Exception e){
            logger.error("Exception occured while creating airport", e);
        }
        return false;
    }
}
