package com.example.movies.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity(debug = true)

public class SecurityConfig extends WebSecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(req-> req
                        .anyRequest().authenticated())
                .formLogin(login->login.loginPage("login").permitAll());

    }
}
