package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Quotation {

    public static final String APPROVED_STATUS = "Approved";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date quote_date;
    @Column(nullable = true)
    private String status;
    @Column(nullable = true)
    private java.sql.Date deliveryDate;
    @Column(nullable = false)
    private java.sql.Date quoteValidity;
    @Column(nullable = false)
    private Boolean transport;
    private float discount;
    @Column(nullable = false)
    private Float initialPrice;
    @Column(nullable = false)
    private Float totalPrice;
    private String go_down_address;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendorPRId", nullable = false)
    @JsonIgnore
    private VendorPR vendorPR;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
//    private PurchaseRequisition purchaseRequisition;


}