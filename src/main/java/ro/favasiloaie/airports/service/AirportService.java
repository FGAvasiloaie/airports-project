package ro.favasiloaie.airports.service;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Search;
import ro.favasiloaie.airports.payload.AirportPayload;

import java.util.List;

public interface AirportService {

    Page<Airport> listAll(int pageNum, String sortField, String sortDir);

    Airport createAirport(String name);

    Airport updateAirport(AirportPayload payload);

}
