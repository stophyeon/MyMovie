package com.example.movies.dto;

import com.example.movies.domain.Agree;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String userName;
    private String password;
    private Date birth;
    private String phoneNum;
    private String address;
    private Agree marketingAgree;

}
