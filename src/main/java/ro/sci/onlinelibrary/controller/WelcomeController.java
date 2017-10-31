package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.repository.BookRepository;
import ro.sci.onlinelibrary.service.BookService;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/home")
    public String homeForm(Model model) {
        return "home";
    }

    @GetMapping(value = "/homeBooks")
    public String homeBook(Model model) {
        return "homeBooks";
    }

    @GetMapping(value = "/homeUsers")
    public String homeUser(Model model) {
        return "homeUsers";
    }

}