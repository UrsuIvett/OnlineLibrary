package ro.sci.onlinelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.onlinelibrary.model.user.User;
import ro.sci.onlinelibrary.service.UserService;

import java.util.List;

/**
 * Created by Ivett on 01-Oct-17.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getUsers() {
        List<User> users = userService.getAll();
        return new ModelAndView("usersView", "users", users);
    }
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchUsers(@RequestParam(value = "searchField", required = false, defaultValue = "") String search) {
        List users = userService.findByField(search);
        return new ModelAndView("userSearchView", "searchResult", users);
    }

    @RequestMapping(value = "/users/searchById", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchUserById(@RequestParam(value = "search", required = false, defaultValue = "0") Integer searchById) {
        List users = userService.findById(searchById);
        return new ModelAndView("searchUserByIdView", "searchResultById", users);
    }
}