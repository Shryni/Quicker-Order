package com.nci.cad.quickerorder.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public abstract class QuotationObj {
    public String title;
    public abstract double price(double qPrice);
}
