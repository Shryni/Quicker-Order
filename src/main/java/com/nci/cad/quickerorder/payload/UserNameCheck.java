package com.nci.cad.quickerorder.payload;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserNameCheck {
    @NotBlank
    private String userNameValue;
    private Boolean isAvailable;
}
