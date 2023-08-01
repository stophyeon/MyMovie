package com.example.movies.config;

import com.example.movies.service.PrincipalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig{
    private final PrincipalService principalService;

    public SecurityConfig(PrincipalService principalService) {
        this.principalService = principalService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)->web.ignoring().requestMatchers("/");
    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable())
                //페이지 권한 설정
                .authorizeHttpRequests(authorize-> authorize
                        .requestMatchers("/**").permitAll()
                        )
                //폼 로그인
                .formLogin(login->login
                        .loginPage("/loginPage")
                        .loginProcessingUrl("/user/login")
                        .defaultSuccessUrl("/",false)
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .failureUrl("/user/find"))
                //로그 아웃
                .logout(logout->logout
                            .logoutSuccessUrl("/")
                        );


        return http.build();
    }
}
