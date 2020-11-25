package ro.favasiloaie.airports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.favasiloaie.airports.model.Airport;
import ro.favasiloaie.airports.repository.AirportRepository;
import ro.favasiloaie.airports.service.AirportService;


import java.util.List;

@Controller
public class AirportController {


    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;


    @GetMapping("/airports")
    public String viewPage(Model model,
                           @Param("pageNum") Integer pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir,
                           @Param("keyword") String keyword) {
        // dam valori default parametrilor de request care nu vin cu "valoare" din request
        if (pageNum == null || pageNum.intValue() == 0) {
            pageNum = 1;
        }
        if (sortField == null || "".equals(sortField.trim())) {
            sortField = "id";
        }
        if (sortDir == null || "".equals(sortDir.trim())) {
            sortDir = "asc";
        }
        if (keyword == null) {
            keyword = "";
        }

        Page<Airport> page = airportService.listAll(pageNum, sortField, sortDir, keyword);

        List<Airport> airports = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("keyword", keyword);
        model.addAttribute("airports", airports);


        return "pagination";
    }

}
