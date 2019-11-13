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

@Entity
@Table
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date quote_date;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private java.sql.Date deliveryDate;
    @Column(nullable = false)
    private java.sql.Date quoteValidity;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendorStore_id" , nullable = false)
    @JsonIgnore
    private VendorStore vendorStore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
    @JsonIgnore
    private PurchaseRequisition purchaseRequisition;

    public Boolean getTransport() {
        return this.transport;
    }

}

