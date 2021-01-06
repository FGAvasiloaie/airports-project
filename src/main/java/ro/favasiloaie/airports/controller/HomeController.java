package ro.favasiloaie.airports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {

    @GetMapping({"/", "/home", "/index"})
    public String showHome(Principal principal) {
        return principal!=null ? "homeSignedIn" : "home";
    }

}