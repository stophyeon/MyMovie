package com.example.movies.controller;

import com.example.movies.domain.User.User;
import com.example.movies.domain.User.UserForm;
import com.example.movies.dto.UserDto;
import com.example.movies.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/join")
    public String join(){return "signup";}
    @GetMapping("/login")
    public String login(){return "loginPage";}
    @PostMapping("/join")
    public String newJoin(@Valid UserDto userDto, Model model){
        if (userService.signup(userDto)){return "loginPage";}
        else{return "findPW";}
    }
    @GetMapping("/find")
    public String findUser(){return "findPW";}

}
