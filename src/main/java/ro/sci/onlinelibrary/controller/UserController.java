package ro.sci.onlinelibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.book.Book;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.repository.UserRepository;
import ro.sci.onlinelibrary.service.UserService;

import java.util.List;

/**
 * Created by Ivett on 01-Oct-17.
 */

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    //Search all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getUsers(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List<User> users = userService.findByField(search);
        return new ModelAndView("users", "searchResult", users);
    }

    //Ask view user
    @GetMapping(value = "/readUser/{id}")
    public String userView(Model model, @PathVariable(name = "id") int id) {
        User user = userService.searchById(id);
        model.addAttribute("user", user);
        return "readUser";
    }

    //Ask submit new user
    @GetMapping(value = "/addUser")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    //Submit new user
    @PostMapping(value = "/addUser")
    public String userForm(Model model, @ModelAttribute User user) {
        userService.add(user);
        model.addAttribute("message", "User saved!");
        model.addAttribute("searchResult", userService.getAll());
        return "users";

    }

    //Delete an user
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(Model model, @PathVariable(name = "id") int id) {
        userService.delete(id);
        model.addAttribute("message", "User deleted!");
        model.addAttribute("searchResult", userService.getAll());
        LOGGER.info("New user was deleted from Database, with following id: "+id);
        return "users";
    }

    //Ask for update an user
    @GetMapping(value = "/updateUser/{id}")
    public String updateUserForm(Model model, @PathVariable(name = "id") int id) {
        User user = userService.searchById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    //Update an user
    @PostMapping(value = "/updateUser/{id}")
    public String updateUserForm(Model model, @ModelAttribute User user) {
        User updateUser = userService.searchById(user.getId());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setPhone(user.getPhone());
        updateUser.setEmail(user.getEmail());
        updateUser.setPaid(user.isPaid());
        userService.update(updateUser);
        model.addAttribute("message", "User updated!");
        model.addAttribute("searchResult", userService.getAll());
        LOGGER.info("New user was added to Database, with following email: "+updateUser.getEmail());
        return "users";
    }

}