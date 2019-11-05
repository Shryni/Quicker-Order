package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Quotation {
    @Id
    private long id;
    private Date quote_date;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private Date delivery_date;
    @Column(nullable = false)
    private String quote_validity;
    @Column(nullable = false)
    private boolean transport;
    @Column(nullable = false)
    private float price;
    @ManyToOne
    @JoinColumn
    private VendorStore vendorStore;
    @ManyToOne
    @JoinColumn
    private PurchaseRequisition purchaseRequisition;
}

