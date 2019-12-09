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
public class VendorRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int deliveryDateRating;
    @Column(nullable = false)
    private int priceRating;
    @Column(nullable = false)
    private int transportRating;
    @Column(nullable = false)
    private int discountRating;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "vendorStore_id", nullable = false)
//    @JsonIgnore
//    private VendorStore vendorStore;
}
