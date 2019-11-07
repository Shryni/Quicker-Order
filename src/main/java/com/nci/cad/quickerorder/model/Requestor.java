package com.nci.cad.quickerorder.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column( unique = true)
    private String role_id;
    private String role;

    @ManyToOne
    @JoinColumn(name="requestorStore_id", nullable = false)
    private RequestorStore requestorStore;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval = true,mappedBy="requestor")
    private List<PurchaseRequisition> purchase_requisitions;
}
