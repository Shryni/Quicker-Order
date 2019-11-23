package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Requestor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    //@Column( unique = true)
    //private String role_id;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="requestorStore_id", nullable = false)
    @JsonIgnore
    private RequestorStore requestorStore;


//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
//            mappedBy = "requestor")
//    private List <PurchaseRequisition> purchaseRequisitions;

}
