package com.nci.cad.quickerorder.model;

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
    private String id;
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
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="quotation")
    private List<Item> items;
    @ManyToOne
    @JoinColumn(name = "vendorStore_id" , nullable = false)
    private VendorStore vendorStore;
    @ManyToOne
    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
    private PurchaseRequisition purchaseRequisition;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="quotation")
    private Purchaseorder purchaseorder;

    public Boolean getTransport() {
        return this.transport;
    }
}

