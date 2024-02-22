package org.example.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.domain.Principal;
import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class PrincipalService implements UserDetailsService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PrincipalService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()
                ->new UsernameNotFoundException("아이디를 찾을 수 없습니다"));

        return new Principal(user);
    }
}
