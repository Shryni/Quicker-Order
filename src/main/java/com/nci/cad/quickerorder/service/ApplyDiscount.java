package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyDiscount {

    @Autowired
    Quotation_Repository quotation_repository;

    public Quotation addDiscountToQuotation(Long reqID, Long purchaseRequistionID, Quotation quotation) {

        int noOfOrders = quotation_repository.findQuotationByPurchaserequitionId(reqID, purchaseRequistionID, "Approved");

        if (noOfOrders != 0) {
            quotation.setTotalPrice((float) (quotation.getTotalPrice() * 0.95));
        } else {
            quotation.setDiscount(quotation.getTotalPrice());
        }
        return quotation;
    }
}





