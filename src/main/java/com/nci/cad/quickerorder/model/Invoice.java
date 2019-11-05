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
    private long id;
    @Column(nullable = false)
    private Date quote_date;
    @Column(nullable = false)
    private Date due_date;
    private String status;
    @OneToOne
    @JoinColumn(name = "purchaseorder_id", nullable = false)
    private Purchaseorder purchaseorder;


}
