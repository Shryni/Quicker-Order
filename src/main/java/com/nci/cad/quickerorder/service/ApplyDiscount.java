package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyDiscount {

    @Autowired
    Quotation_Repository quotation_repository;

    public Quotation addDiscountToQuotation(Long reqID, Long vendorStoreID, Quotation quotation) {
        System.out.println("REQ ID: "+ reqID);
        System.out.println("vendorStoreID ID: "+ vendorStoreID);
        System.out.println("Quotation ID: "+ quotation);
         int noOfOrders = quotation_repository.findQuotationByPurchaserequitionId(reqID, vendorStoreID,"Approved");

        if (noOfOrders !=0 && noOfOrders>2) {
            quotation.setTotalPrice((float) (quotation.getTotalPrice() * 0.95));
        } else {
            quotation.setTotalPrice(quotation.getTotalPrice());
        }
        return quotation;
    }
}





