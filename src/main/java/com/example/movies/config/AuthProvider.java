package com.example.movies.config;

import com.example.movies.service.PrincipalService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
@Component
public class AuthProvider implements AuthenticationProvider {

    private final PrincipalService principalService;

    public AuthProvider(PrincipalService principalService) {

        this.principalService = principalService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        Optional.ofNullable(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User name or User Password"));
        try {
            UserDetails userDetails = principalService.loadUserByUsername(username);
            String password = userDetails.getPassword();
            if (authentication.getCredentials()==userDetails.getPassword()){
                return authentication;
            }


            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            return UsernamePasswordAuthenticationToken.authenticated(username, password, authorities);
        } catch (Exception ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
