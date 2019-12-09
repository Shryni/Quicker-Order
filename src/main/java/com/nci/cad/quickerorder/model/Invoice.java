package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    //private java.sql.Date quote_date;
    //@Column(nullable = false)
    private Date date;
    private String status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseorder_id", nullable = false)
    @JsonIgnore
    private Purchaseorder purchaseorder;
}
