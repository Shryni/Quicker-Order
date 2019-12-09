package com.nci.cad.quickerorder.payload;

public class VendorQuotation extends QuotationObj {
    public VendorQuotation(){
        title="VendorQuotation";
    }
    @Override
    public double price(double qPrice) {
        return qPrice;
    }
}
