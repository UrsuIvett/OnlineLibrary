package ro.sci.onlinelibrary.controller;

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

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //show all users
    @GetMapping(value = "/users")
    @ResponseBody
    public ModelAndView getUsers() {
        List<User> users = userService.getAll();
        return new ModelAndView("usersView", "users", users);
    }
    //search users from repository
    @GetMapping(value = "/users/search")
    @ResponseBody
    public ModelAndView searchUsers(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List users = userService.findByField(search);
        return new ModelAndView("userSearchView", "searchResult", users);
    }

    //show user by id
    @GetMapping(value = "/users/searchById")
    @ResponseBody
    public ModelAndView searchUserById(@RequestParam(value = "search", required = false,defaultValue = "0") Integer searchById) {
        User user = userService.findById(searchById);
        return new ModelAndView("searchUserByIdView", "searchResultById", user);
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
        return "User saved!";
    }


    //Delete a user

    @RequestMapping(value  = "/deleteUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(User user) {
        userRepository.delete(user.getId());
        return "User deleted";
    }
}