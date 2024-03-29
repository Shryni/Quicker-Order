package com.nci.cad.quickerorder.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

}
