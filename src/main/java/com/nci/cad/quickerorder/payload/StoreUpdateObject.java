package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreUpdateObject {

    private String name;


    private String email;

    private String storeAddress_line1;

    private String storeAddress_line2;

    private String storeAddress_line3;

    private String store_city;

    private String store_postal_code;

    private String store_contact;

    private long approval_limit;
    private String delivery_address;
}











