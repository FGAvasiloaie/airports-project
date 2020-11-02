package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.favasiloaie.airports.repository.AirportRepository;

@Controller
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/airports/{airportId}")
    public String retrieveAirportInfo(@PathVariable("airportId") final Long id, final Model model) {
        model.addAttribute("a", airportRepository.getOne(id));
        return "my-airport";
    }
}
