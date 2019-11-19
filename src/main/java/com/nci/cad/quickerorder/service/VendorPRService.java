package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.repository.Item_Repository;
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

    @Autowired
    Item_Repository item_repository;

    public String addPRsToVendors(Long prID, Long[] vendors) {
        PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.findById(prID).get();
        List<Item> items = item_repository.findByPurchaseRequisitionId(prID);
        if(items != null){
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
                VendorPR vendorPR1 = vendorPR_repository.save(vendorPR);
                for (Item item:
                        items) {
                    item.setVendorPR(vendorPR1);
                    item_repository.save(item);
                }
            }
            return "Updated the PR to vendors!!!";
        }
        else{
            return "No items found in the PR";
        }
    }
}
