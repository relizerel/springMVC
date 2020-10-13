package com.spring.controller;


import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    public UsersController(){}

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users/")
    public ModelAndView index(){
        List<User> listUsers = userService.listUsers();
        ModelAndView modelAndView = new ModelAndView("users/users");
        modelAndView.addObject("allUsers", listUsers);
        return modelAndView;
    }

    @GetMapping(value = "/users/save")
    public ModelAndView saveUser() {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/");
        modelAndView.addObject("saveUser", userService.saveUser(new User()));
        return modelAndView;
    }

    @GetMapping(value = "/users/update/{id}")
    public ModelAndView updateUser(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/");
        User user = userService.getUser(id);
        modelAndView.addObject("updateUser", userService.updateUser(user));
        return modelAndView;
    }

    @GetMapping(value = "/users/delete/{id}")
    public ModelAndView deleteUser(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/");
        User user = userService.getUser(id);
        modelAndView.addObject("deleteUser", userService.deleteUser(user));
        return modelAndView;
    }

    @GetMapping(value = "/users/find/{id}")
    public ModelAndView getUser(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("users/find");
        modelAndView.addObject("getUser", userService.getUser(id));
        return modelAndView;
    }


/*
    @GetMapping(value = "/save")
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return (User) userService.saveUser(user);
    }

    @GetMapping(value = "/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return (User) userService.updateUser(user);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public User deleteUser(@RequestBody User user) {
        return (User) userService.deleteUser(user);
    }


    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public User getUser(@PathVariable long id) {
        return (User) userService.getUser(id);
    }

 */

    /*
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("users");
    modelAndView.addObject("allUsers", userService.getAllUsers());
    return modelAndView;
}
 */
}
