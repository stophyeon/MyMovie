package org.example.dto;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.domain.Role;


@Data
@RequiredArgsConstructor
public class UserDto {
    private String email;
    private String userName;
    private String password;
    private String birth;
    private String phoneNum;
    private String address;
    private Role role;

}
