package ro.sci.onlinelibrary.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(value = "/home")
    public String bookForm(Model model) {
        return "home";
    }
}