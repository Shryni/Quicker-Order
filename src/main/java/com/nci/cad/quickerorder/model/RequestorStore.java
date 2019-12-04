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
@AllArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class RequestorStore extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

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
    private String email;

    private String storeAddress_line1;

    private String storeAddress_line2;

    private String storeAddress_line3;

    private String store_city;

    private String store_postal_code;

    private String store_contact;

    private long approval_limit;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "requestorStore_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public RequestorStore(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}











