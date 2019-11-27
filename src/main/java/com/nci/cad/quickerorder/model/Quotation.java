package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Date quote_date;
    //@Column(nullable = true)
    private Boolean status;
    @Column(nullable = true)
    private java.sql.Date deliveryDate;
    @Column(nullable = false)
    private boolean transport;
    private float discount;
    @Column(nullable = false)
    private Float totalPrice;

//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="quotation")
//    private List<Item> items;
//
//    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="quotation")
//    private Purchaseorder purchaseorder;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "vendorStore_id" , nullable = false)
//    @JsonIgnore
//    private VendorStore vendorStore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendorPRId", nullable = false)
    @JsonIgnore
    private VendorPR vendorPR;

    public Boolean getTransport() {
        return this.transport;
    }

}