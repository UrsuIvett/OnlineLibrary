package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.user.Login;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.logging.Logger;

/**
 * Created by iulia on 10/16/2017.
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger("Onlinelibrary");

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());

        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        User user = userService.validateUser(login);
        if (user.getPassword() != null && user.getUsername() != null) {
            mav = new ModelAndView("welcome");
            mav.addObject("user", user);
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

}





