package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class VendorStore {
    @Id
    private long id;
    @Column(nullable = false)
    private String vendor_store_name;
    @Column(nullable = false)
    private String vendor_storeAddress_line1;
    private String vendor_storeAddress_line2;
    private String vendor_storeAddress_line3;
    @Column(nullable = false)
    private String vendor_store_city;
    @Column(nullable = false)
    private String vendor_store_postal_code;
    @Column(nullable = false)
    private String vendor_store_contact;
    @Column(nullable = false)
    private String vendor_store_email;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Quotation> quotations;
}
