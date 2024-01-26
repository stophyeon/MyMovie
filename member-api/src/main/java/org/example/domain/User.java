package org.example.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;


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
    @Pattern(regexp = "[0-9]{4}[-]?[0-9]{2}[-]?[0-9]{2}", message = "날짜 포멧 안맞아요")
    private String birth;
    private String phoneNum;
    private String address;
    @Enumerated(value=EnumType.STRING)
    private Role role;

    @Builder
    public User(Long userId, String email, String userName, String password, String birth, String phoneNum, String address, Role role) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birth = birth;
        this.phoneNum = phoneNum;
        this.address = address;

        this.role = role;
    }
}
