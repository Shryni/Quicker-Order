package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class VendorPR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Date created_date;
    @Column(nullable = false)
    private Date expected_date_of_delivery;
    @Column(nullable = false)
    private String status;
    private String additional_comments;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendorstore_id", nullable = false)
    @JsonIgnore
    private VendorStore vendorStore;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaserequisition_id", nullable = false)
    @JsonIgnore
    private PurchaseRequisition purchaseRequisition;

    @Transient
    private String requestor;
}