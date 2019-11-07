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
public class Invoice {
    @Id
    private String id;
    @Column(nullable = false)
    private Date quote_date;
    @Column(nullable = false)
    private Date date;
    private String status;
    @OneToOne
    @JoinColumn(name = "purchaseorder_id", nullable = false)
    private Purchaseorder purchaseorder;


}
