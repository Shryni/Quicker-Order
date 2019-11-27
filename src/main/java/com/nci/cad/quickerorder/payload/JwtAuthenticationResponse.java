package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
