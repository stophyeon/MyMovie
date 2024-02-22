package org.example.service;

import org.example.dto.UserDto;
import org.example.jwt.JwtProvider;
import org.example.jwt.JwtTokenDto;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtLoginService {
    private final JwtProvider jwtProvider;
    private final AuthenticationProvider authenticationProvider;

    public JwtLoginService(JwtProvider jwtProvider, AuthenticationProvider authenticationProvider) {
        this.jwtProvider = jwtProvider;
        this.authenticationProvider = authenticationProvider;

    }
    public JwtTokenDto loginMember(UserDto memberDto){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(memberDto.getEmail(),memberDto.getPassword());
        Authentication auth = authenticationProvider.authenticate(token);
        return jwtProvider.generateTokenDto(auth);
    }
}
