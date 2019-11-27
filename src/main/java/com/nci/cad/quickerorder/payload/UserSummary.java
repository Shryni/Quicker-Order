package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSummary {
    private Long id;
    private String username;
    private String name;
}
