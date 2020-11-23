package ro.favasiloaie.airports.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.favasiloaie.airports.model.Message;
import ro.favasiloaie.airports.service.MessageService;

@Controller
public class ContactController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/contact")
    public String retrieveContactPage(final Model model) {
        model.addAttribute("message", new Message());
        return "contact";
    }

    @PostMapping("/post_message")
    public String displayResults(final Model model, @ModelAttribute final Message message) {
        messageService.insertIntoDatabase(message);
        model.addAttribute("msg", "Info sent to admin");
        return "greetings";
    }

}
