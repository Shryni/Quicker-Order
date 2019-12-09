package com.nci.cad.quickerorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nci.cad.quickerorder.utils.EmailOnUpdate;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Observable;
import java.util.Observer;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
//public class Requestor  {
public class Requestor extends EmailOnUpdate implements Observer  {

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
    @Email
    private String requestor_email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="requestorStore_id", nullable = false)
    @JsonIgnore
    private RequestorStore requestorStore= new RequestorStore();

    @Override
    public void update(Observable o, Object arg) {
        //System.out.print(o.toString());

        sendEmail(requestor_email);

    }

//    @Override
//    public String toString() {
//        return "Requestor{" +
//                "id=" + id +
//                ", first_name='" + first_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", role='" + role + '\'' +
//                ", requestor_email='" + requestor_email + '\'' +
//                ", requestorStore=" + requestorStore +
//                '}';
//    }
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
//            mappedBy = "requestor")
//    private List <PurchaseRequisition> purchaseRequisitions;

}
