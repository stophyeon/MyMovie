package org.example.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import org.example.domain.UserForm;
import org.example.dto.UserDto;
import org.example.jwt.JwtTokenDto;
import org.example.service.JwtLoginService;
import org.example.service.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtLoginService jwtLoginService;

    public UserController(UserService userService, JwtLoginService jwtLoginService) {
        this.userService = userService;

        this.jwtLoginService = jwtLoginService;
    }
    @ApiOperation(value="User 로그인", notes="Response로 JWT 반환")
    @GetMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @ApiParam(value = "이메일, 비밀번호", required = true) UserDto memberDto){
        JwtTokenDto jwt = jwtLoginService.loginMember(memberDto);
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }

    @PostMapping("/join")
    @ApiOperation(value="User 회원가입")
    public String newJoin(@Valid @RequestBody  @ApiParam(value = "이메일, 비밀번호", required = true)UserDto userDto){
        if(userService.signup(userDto)){return "가입에 성공했습니다";}
        else return "이미 가입된 회원입니다";
    }



}
