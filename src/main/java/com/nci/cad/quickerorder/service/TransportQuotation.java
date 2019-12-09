package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.payload.QuotationObj;
import com.nci.cad.quickerorder.payload.QuotationObjDecorator;

public class TransportQuotation extends QuotationObjDecorator {
    QuotationObj quotationObj;
    public TransportQuotation(QuotationObj quotationObj){
        this.quotationObj = quotationObj;
    }
    @Override
    public String getTitle() {
        return quotationObj.getTitle()+" ,with Transportation cost";
    }

    @Override
    public double price(double qPrice) {
        return quotationObj.price(qPrice)+ 10;
    }
}
