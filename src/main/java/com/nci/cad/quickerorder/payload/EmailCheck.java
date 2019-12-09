package com.nci.cad.quickerorder.payload;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class EmailCheck {
    @NotBlank
    private String emailValue;

    private Boolean isAvailable;
}
