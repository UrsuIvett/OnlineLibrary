package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;

/**
 * Created by iulia on 10/16/2017.
 */
@Controller
public class WelcomeController {
    @GetMapping(value = "/")
    public String homeForm() {
        return "index";
    }
}