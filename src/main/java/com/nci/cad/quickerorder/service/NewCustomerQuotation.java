package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.payload.QuotationObj;
import com.nci.cad.quickerorder.payload.QuotationObjDecorator;

public class NewCustomerQuotation extends QuotationObjDecorator {
    QuotationObj quotationObj;
    public NewCustomerQuotation(QuotationObj quotationObj){
        this.quotationObj = quotationObj;
    }
    @Override
    public String getTitle() {
        return quotationObj.getTitle()+" ,with New Customer discount";
    }

    @Override
    public double price(double qPrice) {
        return quotationObj.price(qPrice)-(qPrice*0.15);
    }
}
