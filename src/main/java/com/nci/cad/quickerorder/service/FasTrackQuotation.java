package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.payload.QuotationObj;
import com.nci.cad.quickerorder.payload.QuotationObjDecorator;

public class FasTrackQuotation extends QuotationObjDecorator {
    QuotationObj quotationObj;
    public FasTrackQuotation(QuotationObj quotationObj){
        this.quotationObj = quotationObj;
    }
    @Override
    public String getTitle() {
        return quotationObj.getTitle()+" ,with Fast Track Delivery";
    }

    @Override
    public double price(double qPrice) {
        return (quotationObj.price(qPrice)+ 30);
    }
}
