package org.example.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long userId;

    private String email;
    private String userName;
    private String password;
    private String birth;
    private String phoneNum;
    private String address;
    private String role;

    @Builder
    public User(Long userId, String email, String userName, String password, String birth, String phoneNum, String address,String role) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birth = birth;
        this.phoneNum = phoneNum;
        this.address = address;
        this.role= role;

    }
}
