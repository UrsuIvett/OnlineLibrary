package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by iulia on 10/16/2017.
 */

@Controller
public class RegistrationController {

    private static final Logger LOGGER = Logger.getLogger("Onlinelibrary");

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());

        return "createNewAccount";
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public String registerForm(@ModelAttribute User user) {
        LOGGER.log(Level.INFO, "Creating a new account");
        userRepository.create(user);
        return "Registration successful";
    }
}

