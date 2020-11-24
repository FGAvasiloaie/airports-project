package ro.favasiloaie.airports.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {


}
