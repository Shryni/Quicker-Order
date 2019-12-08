package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.payload.QuotationObj;
import com.nci.cad.quickerorder.payload.QuotationObjDecorator;

public class RegularCustomerQuotation extends QuotationObjDecorator {
    QuotationObj quotationObj;
    public RegularCustomerQuotation(QuotationObj quotationObj){
        this.quotationObj = quotationObj;
    }
    @Override
    public String getTitle() {
        return quotationObj.getTitle()+" ,with Regular Customer discount";
    }

    @Override
    public double price(double qPrice) {
        return quotationObj.price(qPrice)-(qPrice*0.05);
    }
}

