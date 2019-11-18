package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class VendorStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="vendorStore")
//    private List<Quotation> quotations;


}
