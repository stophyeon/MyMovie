package com.example.movies.service;



import com.example.movies.domain.User.User;
import com.example.movies.dto.UserDto;
import com.example.movies.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
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
                .password(passwordEncoder.encode(userDto.getPassword()))
                .address(userDto.getAddress())
                .phoneNum(userDto.getPhoneNum())
                .userName(userDto.getUserName()).build();
        userRepository.save(user);
        return true;
    }

}
