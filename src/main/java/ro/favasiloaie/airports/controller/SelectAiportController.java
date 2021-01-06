package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Flight;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.repository.FlightRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
public class SelectAiportController {
    @Autowired
private AirportRepository airportRepository;
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/select")
    public ModelAndView displayAirport(@Param("id")  Long id) {

        final ModelAndView mav = new ModelAndView("selected");
        final Optional<Airport> airport = airportRepository.findById(id);
        final String aiportName = airport.map(a -> a.getName()).orElse("Without name!");
        final String airportCountry = airport.map(a -> a.getCountry()).orElse("Without Country!");
        final Integer airportAltitude = airport.map(a -> a.getAltitude()).orElse(0);
        final String airportCity = airport.map(a -> a.getCity()).orElse("Nu avem Oras");
        id = airport.map(a -> a.getId()).orElse(null);
        final BigDecimal  airportLatitude = airport.map(a -> a.getLatitude()).orElse(BigDecimal.ZERO);
        final BigDecimal airportLongitude = airport.map(a -> a.getLongitude()).orElse(BigDecimal.ZERO);
        final Optional<Airport> departureAirport = airportRepository.findById(id);
        final  Airport airportDeparture = departureAirport.get();
        final List<Flight> departureFlights = departureAirport.map(departure -> flightRepository.findByDepartureAirport(airportDeparture).orElse(new ArrayList<>())).get();
        final Optional<Airport> arrivalAirport = airportRepository.findById(id);
        final Airport airportArrival = arrivalAirport.get();
        final List<Flight> arrivalFlights = arrivalAirport.map(listDf -> flightRepository.findByArrivalAirport(airportDeparture).orElse(new ArrayList<>())).get();

        mav.addObject("airportName", aiportName);
        mav.addObject("airportCountry", airportCountry);
        mav.addObject("airportAltitude", airportAltitude);
        mav.addObject("airportCity", airportCity);
        mav.addObject("id", id);
        mav.addObject("airportLatitude", airportLatitude);
        mav.addObject("airportLongitude", airportLongitude);
        mav.addObject("departureFlights", departureFlights);
        mav.addObject("arrivalFlights", arrivalFlights);
        return mav;
    }
}
