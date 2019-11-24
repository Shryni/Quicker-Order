package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {
    private Boolean success;
    private String message;

}