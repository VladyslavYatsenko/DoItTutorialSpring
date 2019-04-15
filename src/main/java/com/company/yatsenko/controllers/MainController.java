package com.company.yatsenko.controllers;

import com.company.yatsenko.dao.UserDao;
import com.company.yatsenko.model.User;
import com.company.yatsenko.services.UserService;
import com.company.yatsenko.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/view/{userName}")//by first request//if u use just RequestParam() u can use without {userName}
    public String view(@PathVariable(value = "userName") String userName, Model model) {//@RequestParam(value = "name", required = false, defaultValue = "stranger") String name
        model.addAttribute("msg", "HELLO " + userName + " FROM VIEW");
        return "index";
    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        System.out.println("Http Request on /raw");
        return "Raw data";
    }

    @GetMapping("/users")
    public String getUsers(Model model) throws SQLException {

        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "/sign_up";
    }

    @PostMapping("/users/new")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {//To create model with request from the user
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/sign_up";
        }

        userService.addUser(user);
        System.err.println(user.toString());
        return "redirect:/users";//Redirect to users page
    }
}
