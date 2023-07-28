package com.example.movies.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Email
    private String email;
    @Max(10)
    private String userName;
    private String password;
    @Pattern(regexp = "yymmdd")
    private Date birth;
    private String phoneNum;
    private String address;
    @Enumerated(value=EnumType.STRING)
    private Agree marketingAgree;
}
