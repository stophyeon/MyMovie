package org.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

}
