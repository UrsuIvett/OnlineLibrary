package ro.sci.onlinelibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.List;

/**
 * Created by Ivett on 01-Oct-17.
 */

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserController");

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getUsers() {
        List<User> users = userService.findAll();
        return new ModelAndView("userView", "users", users);
    }

    //Search books from repository
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchUsers(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List users = userService.findByField(search);
        return new ModelAndView("userSearchView", "searchResult", users);
    }

    //Ask submit new user
    @GetMapping(value = "/registration")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    //Submit new user
    @PostMapping(value = "/registration")
    @ResponseBody
    public String userForm(@ModelAttribute User user) {
        userRepository.add(user);
        LOGGER.info("New user was added to Database, with following email: "+user.getEmail());
        return "User saved!";
    }


    //Delete a user- trebuie sa schimbam cu post

    @RequestMapping(value  = "/deleteUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(User user) {
        userRepository.delete(user.getId());
        LOGGER.info("New user was deleted from Database, with following email: "+user.getEmail());
        return "User deleted";
    }
}