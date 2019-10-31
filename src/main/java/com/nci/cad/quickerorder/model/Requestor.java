package com.nci.cad.quickerorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Requestor {
    @Id
    private long id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column( unique = true)
    private String role_id;
    private String role;
    @OneToOne(mappedBy="requestors",  fetch = FetchType.LAZY)
    private RequestorStore requestorStore;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Purchase_Requisition> purchase_requisitions;
}