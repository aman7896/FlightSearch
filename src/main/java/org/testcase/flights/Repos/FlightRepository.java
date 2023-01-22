package org.testcase.flights.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.testcase.flights.Models.Airport;
import org.testcase.flights.Models.Flight;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByOriginAndDestination(Airport origin, Airport destination);
}
