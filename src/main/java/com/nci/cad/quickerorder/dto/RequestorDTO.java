package com.nci.cad.quickerorder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestorDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String role_id;
    private String role;
}
