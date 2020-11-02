package ro.favasiloaie.airports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String retrieveHomePage() {
        return "homepage";
    }
}
