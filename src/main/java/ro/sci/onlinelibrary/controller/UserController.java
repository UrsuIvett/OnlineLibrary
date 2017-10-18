package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.BookService;
import ro.sci.onlinelibrary.service.UserService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ivett on 01-Oct-17.
 */

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger("Onlinelibrary");

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

    //Search users from repository
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchUsers(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List users = userService.findByField(search);
        return new ModelAndView("userSearchView", "searchResult", users);
    }

    //Ask submit new user
    @GetMapping(value = "/newUser")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "submitUser";
    }

    //Submit new user
    @PostMapping(value = "/newUser")
    @ResponseBody
    public String userForm(@ModelAttribute User user) {
        LOGGER.log(Level.INFO, "Added a new user");
        userRepository.add(user);
        return "User saved!";
    }

    //Delete a user

    @RequestMapping(value  = "/deleteUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(User user) {
        LOGGER.log(Level.INFO, "Deleting user");
        userRepository.delete(user.getId());
        return "User deleted";
    }
}