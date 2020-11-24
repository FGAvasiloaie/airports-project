package ro.favasiloaie.airports.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.payload.AirportPayload;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.service.AirportService;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

//

    @Override
    public Page<Airport> listAll(int pageNum, String sortField, String sortDir) {
        int pageSize = 25;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return airportRepository.findAll(pageable);
    }

    @Override
    public Airport createAirport(final String name) {
        final Airport airport = new Airport();
        airport.setName(name);
        final Airport savedAirport = airportRepository.save(airport);
        return savedAirport;
    }

    @Override
    public Airport updateAirport(final AirportPayload payload) {
        final Airport airport = new Airport();
        airport.setId(payload.getId());
        airport.setName(payload.getName());
        final Airport updatedAirport = airportRepository.save(airport);
        return updatedAirport;
    }
}
