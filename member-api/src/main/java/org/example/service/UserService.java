package org.example.service;




import org.example.domain.User;
import org.example.domain.UserForm;
import org.example.dto.UserDto;
import org.example.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
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
    public UserForm login(UserForm userForm){
        Optional<User> user = userRepository.findByEmail(userForm.getEmail());
        if (user.isPresent()){
            if (!passwordEncoder.matches(userForm.getPassword(),user.get().getPassword())) {
                userForm.setPassword("비밀번호가 틀렸습니다");
            }
            return userForm;
        }
        else {
            userForm.setEmail("가입되어있지 않은 회원입니다.");
            return userForm;
        }
    }

}
