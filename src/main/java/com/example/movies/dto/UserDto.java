package com.example.movies.dto;

import com.example.movies.domain.User.Agree;

import com.example.movies.domain.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
public class UserDto {
    private String email;
    private String userName;
    private String password;
    private String birth;
    private String phoneNum;
    private String address;
    private Agree marketingAgree;
    private Role role;

}
