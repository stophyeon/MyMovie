package org.example.controller;


import jakarta.validation.Valid;
import org.example.domain.UserForm;
import org.example.dto.UserDto;
import org.example.service.UserService;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/login")
    public UserForm login(@RequestBody UserForm userForm){
        return userService.login(userForm);

    }

    @PostMapping("/join")
    public String newJoin(@Valid @RequestBody UserDto userDto){
        if(userService.signup(userDto)){return "가입에 성공했습니다";}
        else return "이미 가입된 회원입니다";
    }



}
