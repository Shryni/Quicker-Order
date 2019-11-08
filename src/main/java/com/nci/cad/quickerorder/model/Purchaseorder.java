package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Quo;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Purchaseorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date quote_date;
    @Column(nullable = false)
    private Date date;
    private String status;
    private String comments;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
    @JsonIgnore
    private PurchaseRequisition purchaseRequisition;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quotation_id",nullable = false)
    @JsonIgnore
    private Quotation quotation;

    @OneToOne(cascade = CascadeType.ALL,mappedBy="purchaseorder",  fetch = FetchType.LAZY)
    private Invoice invoice;

}
