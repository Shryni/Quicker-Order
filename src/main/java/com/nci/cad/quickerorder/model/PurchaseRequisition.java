package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class PurchaseRequisition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    //@Column(nullable = false)
    //private Date created_date;
    //@Column(nullable = false)
    private Date expected_date_of_delivery;
    @Column(nullable = false)
    private String status;
    //private String additional_comments;
    //private boolean save_template;
    private JTextArea items;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requestor_id", nullable = false)
    @JsonIgnore
    private Requestor requestor;

//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="purchaseRequisition")
//    private List<Item> items;
//
//    @OneToOne(mappedBy="purchaseRequisition",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Purchaseorder purchaseorder;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="purchaseRequisition")
//    private List<Quotation> quotations;


}
