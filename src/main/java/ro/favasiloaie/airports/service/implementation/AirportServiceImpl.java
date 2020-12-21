package ro.favasiloaie.airports.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

//

    @Override
    public Page<Airport> listAll(int pageNum, String sortField, String sortDir, String keyword) {
        int pageSize = 25;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        if( keyword == null) {
            return airportRepository.findAll(pageable);
        }
        return airportRepository.findAll(keyword, pageable);
    }

}
