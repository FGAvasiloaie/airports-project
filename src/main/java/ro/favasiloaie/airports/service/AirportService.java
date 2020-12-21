package ro.favasiloaie.airports.service;

import org.springframework.data.domain.Page;
import ro.favasiloaie.airports.model.Airport;



public interface AirportService {

    Page<Airport> listAll(int pageNum, String sortField, String sortDir, String keyword);


}
