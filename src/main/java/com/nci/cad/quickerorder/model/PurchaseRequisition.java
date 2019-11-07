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
    private String id;
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
    @ManyToOne
    @JoinColumn(name = "requestor_id", nullable = false)
    private Requestor requestor;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="purchaseRequisition")
    private List<Item> items;
    @OneToOne(mappedBy="purchaseRequisition",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Purchaseorder purchaseorder;
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="purchaseRequisition")
    private List<Quotation> quotations;
}
