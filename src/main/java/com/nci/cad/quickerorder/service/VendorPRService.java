package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import com.nci.cad.quickerorder.repository.VendorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorPRService {

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    VendorStore_Repository vendorStore_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    public void addPRsToVendors(Long prID, Long[] vendors) {
        PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.findById(prID).get();
        List<VendorPR> vendorPRS = null;
        VendorPR vendorPR = new VendorPR();
        vendorPR.setId(purchaseRequisition.getId());
        vendorPR.setTitle(purchaseRequisition.getTitle());
        vendorPR.setCreated_date(purchaseRequisition.getCreated_date());
        vendorPR.setExpected_date_of_delivery(purchaseRequisition.getExpected_date_of_delivery());
        vendorPR.setStatus(purchaseRequisition.getStatus());
        vendorPR.setAdditional_comments(purchaseRequisition.getAdditional_comments());
        for (Long vendorID:vendors
             ) {
                vendorPR.setVendorStore(vendorStore_repository.findById(vendorID).get());
                vendorPR_repository.save(vendorPR);
        }

    }
}
