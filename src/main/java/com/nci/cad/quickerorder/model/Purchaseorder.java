package com.nci.cad.quickerorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Purchaseorder {
    @Id
    private long id;
    private Date quote_date;
    @Column(nullable = false)
    private Date date;
    private String status;
    //private String date;
    private String comments;
    @OneToOne(mappedBy="purchaseRequisition_po",  fetch = FetchType.LAZY)
    private PurchaseRequisition purchaseRequisition;
    @OneToOne(mappedBy="invoice",  fetch = FetchType.LAZY)
    private Invoice invoice;
}
