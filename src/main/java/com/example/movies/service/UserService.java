package com.example.movies.service;


import com.example.movies.domain.User.Principal;
import com.example.movies.domain.User.User;
import com.example.movies.dto.UserDto;
import com.example.movies.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;
    //private final AuthenticationManager authenticationManager;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public boolean duplicated(UserDto userDto){
        return userRepository.findByEmail(userDto.getEmail()).isPresent();
    }
    public boolean signup(UserDto userDto){
        if (duplicated(userDto)){return false;}
        User user = User.builder()
                .birth(userDto.getBirth())
                .role(userDto.getRole())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .address(userDto.getAddress())
                .phoneNum(userDto.getPhoneNum())
                .userName(userDto.getUserName()).build();
        userRepository.save(user);
        return true;
    }
    /*public String login(UserDto userDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(),userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Principal principal = (Principal)authentication.getPrincipal();
        return principal.getUsername();
    }*/
}
