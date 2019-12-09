package com.nci.cad.quickerorder.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Spending {
    @JsonProperty("delivery_date")
    private java.sql.Date deliveryDate=null;
    @JsonProperty("totalPrice")
    private Float totalPrice=null;
}
