package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.controller.RequestorStoreController;
import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.repository.*;
import com.nci.cad.quickerorder.utils.Observer;
import com.nci.cad.quickerorder.utils.Subject;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
public class VendorPRService implements Observer{

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    VendorStore_Repository vendorStore_repository;

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    @Autowired
    Item_Repository item_repository;

    private Subject sub;

    @Override
    public void setSubject(Subject sub) {
        this.sub = sub;
    }
    @Override
    public void update(PurchaseRequisition pr, VendorStore vendorStore) {
        VendorPR vpr = new VendorPR();
        vpr.setId(pr.getId());
        vpr.setTitle(pr.getTitle());
        vpr.setCreated_date(pr.getCreated_date());
        vpr.setExpected_date_of_delivery(pr.getExpected_date_of_delivery());
        vpr.setStatus(pr.getStatus());
        vpr.setAdditional_comments(pr.getAdditional_comments());
        vpr.setVendorStore(vendorStore);
        addVendorPR(vpr);

    }
    public void addVendorPR(VendorPR vpr){
        System.out.println("VPR: "+vpr);
        vendorPR_repository.save(vpr);
    }
//    public void updatePR(VendorPR vpr){
//        vpr.setStatus("Approved");
//        vendorPR_repository.save(vpr);
//    }


    public String addPRsToVendors(Long prID, Long[] vendors) {
        PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.findById(prID).get();
        List<Item> items = item_repository.findByPurchaseRequisitionId(prID);
        if(items != null){
            VendorPR vendorPR = new VendorPR();
            vendorPR.setId(purchaseRequisition.getId());
            vendorPR.setTitle(purchaseRequisition.getTitle());
            //vendorPR.setCreated_date(purchaseRequisition.getCreated_date());
            vendorPR.setExpected_date_of_delivery(purchaseRequisition.getExpected_date_of_delivery());
            vendorPR.setStatus(purchaseRequisition.getStatus());
            //vendorPR.setAdditional_comments(purchaseRequisition.getAdditional_comments());
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

    public VendorPR approveVendorPR(Long id) {
        VendorPR vpr = vendorPR_repository.findById(id).get();
        vpr.setStatus("Approved");
        return vendorPR_repository.save(vpr);
    }
    public List<VendorPR> findApprovedPR(Long id){
        List<VendorPR> vprs = vendorPR_repository.findByVendorStore_id(id);
        List<VendorPR> approved = null;
        for (VendorPR vpr:
             vprs) {
            if(vpr.getStatus().equals("Approved")){
                approved.add(vpr);
            }
        }
        return vprs;
    }

    public List<VendorPR> findAllPrs(Long id) {
        String vendorName = requestorStore_repository.findById(id).get().getName();
        VendorStore vendorStore = vendorStore_repository.findByName(vendorName);
        return vendorPR_repository.findByVendorStore_id(vendorStore.getId());
    }
}
