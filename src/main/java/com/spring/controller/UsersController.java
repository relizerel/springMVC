package com.spring.controller;


import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return (User) userService.saveUser(user);
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return (User) userService.updateUser(user);
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@RequestBody User user) {
        return (User) userService.deleteUser(user);
    }

    @RequestMapping(value = "/users/find/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return (User) userService.getUser(id);
    }

}
