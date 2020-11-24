package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.model.Search;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.service.AirportService;
import ro.favasiloaie.airports.service.MessageService;

import java.util.List;

@Controller
public class AirportController {


    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;



    @GetMapping("airports/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir)
                       {

        Page<Airport> page = airportService.listAll(pageNum, sortField, sortDir);

        List<Airport> airports = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("airports", airports);

        return "pagination";
    }

    @RequestMapping("/airports")
    public String viewAirportsPage(final Model model) {
        return viewPage(model, 1, "country", "asc");
    }

}
