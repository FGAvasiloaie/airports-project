package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.favasiloaie.airports.model.Airline;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Flight;
import ro.favasiloaie.airports.repository.AirlineRepository;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.repository.FlightRepository;
import ro.favasiloaie.airports.service.FlightService;

import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private FlightService flightService;


    @PostMapping("/add")
    public String displayResult(final Model model, @ModelAttribute final Flight myFlight) {
        flightService.insertIntoDatabase(myFlight);
        final List<Flight> flights = flightRepository.findAll();
        model.addAttribute("flights", flights);
        return "add-flight";
    }

    @GetMapping({"/add"})
    public String addFlight(final Model model) {
        final List<Airport> airports = airportRepository.findAll();
        final List<Airline> airlines = airlineRepository.findAll();
        model.addAttribute("myAirports", airports);
        model.addAttribute("myAirlines", airlines);
        model.addAttribute("flight", new Flight());
        return "add-flight";
    }
}