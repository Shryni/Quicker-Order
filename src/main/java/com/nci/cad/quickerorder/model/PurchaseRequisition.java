package com.nci.cad.quickerorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class PurchaseRequisition
{
    @Id
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Date created_date;
    @Column(nullable = false)
    private Date expected_date_of_delivery;
    @Column(nullable = false)
    private String status;
    private String additional_comments;
    private boolean save_template;
    @OneToOne(mappedBy="purchase_requisitions",  fetch = FetchType.LAZY)
    private Requestor requestor;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Quotation> quotations;
    @OneToOne(mappedBy="purchaseRequisition_po",  fetch = FetchType.LAZY)
    private Purchaseorder purchaseorder;

}
