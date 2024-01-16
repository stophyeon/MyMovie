package com.example.movies.service;

import com.example.movies.domain.User.Role;
import com.example.movies.domain.User.User;
import com.example.movies.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=  userRepository.findByEmail(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("이메일과 비밀번호를 확인해주세요");
        }
        else {
            List<GrantedAuthority> auth = new ArrayList<>();
            auth.add(new SimpleGrantedAuthority("user"));
            return new org.springframework.security.core.userdetails.User(user.get().getUserName(),user.get().getPassword(),auth);
        }
    }
}
