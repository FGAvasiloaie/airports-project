package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ro.favasiloaie.airports.model.Flight;
import ro.favasiloaie.airports.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights/{flightNo}")
    public ModelAndView displayFlightByNumber(@PathVariable("flightNo") final String flightNo) {
        final ModelAndView mav = new ModelAndView("flight-by-number");
        final List<Flight> flights = flightRepository.findByFlightNo(flightNo);
        final String flight = flights.stream()
                .findFirst()
                .map(f -> f.getAirline().getName() + " " + f.getAirline().getIata()
                        + "\n" + f.getDepartureAirport().getName() + " " + f.getDepartureAirport().getCountry()
                        + "\n" + f.getArrivalAirport().getName() + " " + f.getArrivalAirport().getCity())
                .orElse("no data");
        mav.addObject("flight", flight);
        return mav;
    }

    @GetMapping("/flights/city/{city}/date/{date}")
    public ModelAndView displayFilteredFlights(@PathVariable("city") final String city,
                                               @PathVariable("date") final String date) {
        final ModelAndView mav = new ModelAndView("filtered-flights");
        final List<Flight> flights = flightRepository
                .findFlightsByCustomRules(LocalDateTime.parse(date), city);
        mav.addObject("flights", flights);
        return mav;
    }
}