package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class RequestorStore {
    @Id
    private long id;
    @Column(nullable = false)
    private String store_name;
    @Column(nullable = false)
    private String storeAddress_line1;
    private String storeAddress_line2;
    private String storeAddress_line3;
    @Column(nullable = false)
    private String store_city;
    @Column(nullable = false)
    private String store_postal_code;
    @Column(nullable = false)
    private String store_contact;
    @Column(nullable = false)
    private String store_email;
    private long approval_limit;
}
