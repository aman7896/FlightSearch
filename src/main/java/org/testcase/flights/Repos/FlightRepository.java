package org.testcase.flights.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.testcase.flights.Models.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
