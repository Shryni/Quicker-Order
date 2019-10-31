package com.nci.cad.quickerorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Item {
    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private int quantity;
    @OneToOne(mappedBy="items",  fetch = FetchType.LAZY)
    private Purchase_Requisition purchase_requisition;
}
