package ro.favasiloaie.airports.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.favasiloaie.airports.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a FROM Airport a WHERE CONCAT(a.name, ' ', a.country, ' ', a.city, ' ', a.iata) LIKE %?1%")
    List<Airport> search(String keyword);


    List<Airport> findByCountryAndCity(String country, String city);
    List<Airport> findByCountry(String country);
    List<Airport> findByCity(String city);

}
