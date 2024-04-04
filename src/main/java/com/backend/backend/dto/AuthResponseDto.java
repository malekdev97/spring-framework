package com.backend.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthResponseDto {

    private String accessToken;
    private String tokenType = "Bearer";
    private String role;
    private String email;
    private String name;
    private Long id;

    public AuthResponseDto() {
        
    }
    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
        //this.tokenType = "Bearer";
    }

    public AuthResponseDto(String accessToken, String role, String email, String name, Long id) {
        this.accessToken = accessToken;
        this.role = role;
        this.email = email;
        this.name = name;
        this.id = id;
    }
}
