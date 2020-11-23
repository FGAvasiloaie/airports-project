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

    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {
        Page<Airport> page = airportService.listAll(pageNum);

        List<Airport> airports = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("airports", airports);

        return "index";
    }

    @RequestMapping("/")
    public String viewAirportsPage(Model model) {
        return viewPage(model, 1);
    }

//    @RequestMapping("/")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<Airport> listAirports = airportService.findFilteredAirports(keyword);
//        model.addAttribute("listAirports",listAirports);
//        model.addAttribute("keyword", keyword);
//        return "homepage";
//    }
//    @RequestMapping("/")
//    public String displaySearchPage(Model model, @Param("keyword") String keyword) {
//        List<Airport> listAirports = airportService.findFilteredAirports(keyword);
//        model.addAttribute("listAirports", listAirports);
//        model.addAttribute("keyword", keyword);
//
//        return "index";
//    }
//
//    @PostMapping("/airports")
//    public ModelAndView displaySearchResults(final Search search) {
//        final ModelAndView modelAndView = new ModelAndView("homepage");
//        final List<Airport> list = airportService.findFilteredAirports(search);
//        modelAndView.addObject("myAirports", list);
//        return modelAndView;
//    }

}
