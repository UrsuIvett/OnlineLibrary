package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ro.sci.onlinelibrary.model.user.Login;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;


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
    public String loginForm(@ModelAttribute Login login) {
        LOGGER.log(Level.INFO, "Login successful");
        return "Login successful";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView showLogin() {
//        ModelAndView mav = new ModelAndView("login");
//        mav.addObject("login", new Login());
//        return mav;
//    }
//
//    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//    public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
//        ModelAndView mav = null;
//        User user = userService.validateUser(login);
//        if (user.getPassword()!=null && user.getUsername()!=null) {
//            mav = new ModelAndView("welcomeUser");
//            mav.addObject("user", user);
//        } else {
//            mav = new ModelAndView("login");
//            mav.addObject("message", "Username or Password is wrong!!");
//        }
//        return mav;
//    }

}