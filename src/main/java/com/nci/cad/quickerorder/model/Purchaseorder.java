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
public class Purchaseorder {
    @Id
    private long id;
    private Date quote_date;
    @Column(nullable = false)
    private Date date;
    private String status;
    //private String date;
    private String comments;
    @OneToOne
    @JoinColumn
    private PurchaseRequisition purchaseRequisition;
    @OneToOne(mappedBy="purchaseorder",  fetch = FetchType.LAZY)
    private Invoice invoice;

}
