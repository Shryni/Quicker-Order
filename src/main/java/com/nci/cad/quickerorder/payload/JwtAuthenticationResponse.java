package com.nci.cad.quickerorder.payload;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.model.Role;
import com.nci.cad.quickerorder.model.VendorStore;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String role;
    RequestorStore requestorStore;
    VendorStore vendorStore;

    public JwtAuthenticationResponse(String accessToken,RequestorStore requestorStore ,VendorStore vendorStore,String role) {

        this.accessToken = accessToken;
        this.role = role;
        this.requestorStore = requestorStore;
        this.vendorStore = vendorStore;
    }

}
