package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class RequestorStore {
    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private String store_name;
    @Column(nullable = false)
    private String storeAddress_line1;
    private String storeAddress_line2;
    private String storeAddress_line3;
    @Column(nullable = false)
    private String store_city;
    @Column(nullable = false)
    private String store_postal_code;
    @Column(nullable = false, unique = true)
    private String store_contact;
    @Column(nullable = false, unique = true)
    private String store_email;
    private long approval_limit;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval = true,mappedBy="requestorStore")
    private List <Requestor> requestors;
}
