package com.nci.cad.quickerorder.payload;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}

