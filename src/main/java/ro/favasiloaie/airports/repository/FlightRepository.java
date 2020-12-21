package ro.favasiloaie.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Flight;


import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<ArrayList<Flight>> findByDepartureAirport(Airport departure);

    Optional<ArrayList<Flight>> findByArrivalAirport(Airport arrival);
}