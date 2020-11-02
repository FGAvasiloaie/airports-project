package ro.favasiloaie.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Airports;

@Repository
public interface AirportRepository extends JpaRepository<Airports, Long> {
}
