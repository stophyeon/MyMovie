package org.example.security_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;



@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final AuthenticationManager authenticationManager;

    public SecurityConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->
                        auth
                                .requestMatchers("/user/login").permitAll()
                                .requestMatchers("/user/join").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form->
                        form
                        .passwordParameter("password")
                        .usernameParameter("email")
                ).build();
                //.addFilter().build();

    }
}
