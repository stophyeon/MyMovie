package org.example.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data

public class JwtTokenDto {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
    @Builder
    public JwtTokenDto(String grantType, String accessToken, String refreshToken,Long accessTokenExpiresIn) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpiresIn =accessTokenExpiresIn;
    }


}
