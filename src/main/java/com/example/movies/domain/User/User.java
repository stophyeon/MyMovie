package com.example.movies.domain.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Email
    private String email;

    private String userName;
    private String password;
    @Pattern(regexp = "yymmdd")
    private String birth;
    private String phoneNum;
    private String address;
    @Enumerated(value=EnumType.STRING)
    private Agree marketingAgree;
    @Enumerated(value=EnumType.STRING)
    private Role role;
    @Builder
    public User(Long userId, String email, String userName, String password, String birth, String phoneNum, String address, Agree marketingAgree, Role role) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birth = birth;
        this.phoneNum = phoneNum;
        this.address = address;
        this.marketingAgree = marketingAgree;
        this.role = role;
    }
}
