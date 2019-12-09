package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewRequestor {
    private Long id;
    private String first_name;
    private String last_name;
    private String role;
    private Long storeID;
    private String email;
}
