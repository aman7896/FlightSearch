package org.testcase.flights.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.testcase.flights.Models.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
