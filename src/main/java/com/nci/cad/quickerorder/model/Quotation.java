package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date quote_date;
    @Column(nullable = false)
    private Boolean status;
    @Column(nullable = true)
    private java.sql.Date deliveryDate;
    @Column(nullable = false)
    private java.sql.Date quoteValidity;
    @Column(nullable = false)
    private Boolean transport;
    private float discount;
    @Column(nullable = false)
    private Float totalPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendorPRId", nullable = false)
    @JsonIgnore
    private VendorPR vendorPR;
}