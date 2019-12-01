package com.nci.cad.quickerorder.model;

import com.nci.cad.quickerorder.model.audit.DateAudit;
import lombok.*;
import org.hibernate.annotations.NaturalId;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor

@ToString
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "vendorStoreName"
        }),
        @UniqueConstraint(columnNames = {
                "vendoremail"
        })
})
public class VendorStore extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String vendorStoreName;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NotBlank
    @Size(max = 100)
    private String password;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String vendoremail;

    private String vendoraddress1;

    private String vendoraddress2;

    private String vendorcity;

    private String vendoreircode;

    private String vendorcontact;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "vendorStore_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public VendorStore(String name, String username, String email, String password) {
        this.vendorStoreName = name;
        this.username = username;
        this.vendoremail = email;
        this.password = password;
    }

}











