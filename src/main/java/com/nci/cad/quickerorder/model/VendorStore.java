package com.nci.cad.quickerorder.model;

import com.nci.cad.quickerorder.model.audit.DateAudit;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
public class VendorStore extends DateAudit {

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

    public VendorStore(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
