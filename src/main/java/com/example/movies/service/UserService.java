package com.example.movies.service;


import com.example.movies.domain.User.User;
import com.example.movies.domain.User.UserForm;
import com.example.movies.dto.UserDto;
import com.example.movies.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void signup(UserDto userDto){
        User user = User.builder()
                .birth(userDto.getBirth())
                .role(userDto.getRole())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .address(userDto.getAddress())
                .phoneNum(userDto.getPhoneNum())
                .userName(userDto.getUserName()).build();
        userRepository.save(user);
        System.out.println(userRepository.findByEmail(userDto.getEmail()).get().getUserName());
    }
}
