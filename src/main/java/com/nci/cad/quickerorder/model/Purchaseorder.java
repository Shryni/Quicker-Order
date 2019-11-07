package com.nci.cad.quickerorder.model;

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
    private String id;
    private Date quote_date;
    @Column(nullable = false)
    private Date date;
    private String status;
    private String comments;
    @OneToOne
    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
    private PurchaseRequisition purchaseRequisition;
    @OneToOne
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    @OneToOne(mappedBy="purchaseorder",  fetch = FetchType.LAZY)
    private Invoice invoice;

}
