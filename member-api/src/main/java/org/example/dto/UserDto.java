package org.example.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.domain.Role;


@Data
@RequiredArgsConstructor
public class UserDto {
    @Email
    private String email;

    private String userName;
    @NotBlank
    private String password;
    @Pattern(regexp = "[0-9]{4}[-]?[0-9]{2}[-]?[0-9]{2}", message = "날짜 포멧 안맞아요")
    private String birth;
    private String phoneNum;
    @JsonIgnore
    private String address;

    private String role="MEMBER";

}
