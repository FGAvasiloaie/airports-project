package ro.favasiloaie.airports.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Airport;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a FROM Airport a WHERE a.name LIKE %?1%"
            + " OR a.country LIKE %?1%"
            + " OR a.city LIKE %?1%")
    Page<Airport> findAll(String keyword, Pageable pageable);

}
