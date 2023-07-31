package com.example.movies.controller;

import com.example.movies.domain.User.User;
import com.example.movies.domain.User.UserForm;
import com.example.movies.dto.UserDto;
import com.example.movies.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


}
