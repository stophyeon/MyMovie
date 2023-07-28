package com.example.movies.controller;

import com.example.movies.dto.UserDto;
import com.example.movies.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public String login(UserDto userDto){

        return "home";
    }
}
