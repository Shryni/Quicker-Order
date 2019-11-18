package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private int quantity;
    //private float price;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseRequisition_id", nullable = false)
    @JsonIgnore
    private PurchaseRequisition purchaseRequisition;
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "quotation_id", nullable = true)
    @JsonIgnore
    private Quotation quotation;




}
