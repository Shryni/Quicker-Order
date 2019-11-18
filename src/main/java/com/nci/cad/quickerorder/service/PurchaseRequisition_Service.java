package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.repository.Item_Repository;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.Requestor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRequisition_Service {

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    @Autowired
    Requestor_Repository requestor_repository;

    public List<PurchaseRequisition> getPRByRequestorID(Long requestorID) {
        return purchaseRequisition_repository.findByRequestorId(requestorID);
    }
    public List<PurchaseRequisition> getAllPR(){
        return purchaseRequisition_repository.findAll();
    }
    public PurchaseRequisition getPRByID(Long prID) {
        return purchaseRequisition_repository.findById(prID).get();
    }

   public PurchaseRequisition addPurchaseRequisition(Long requestorId, PurchaseRequisition purchaseRequisition) throws URISyntaxException {
       Requestor requestor = requestor_repository.findById(requestorId).get();
       purchaseRequisition.setRequestor(requestor);
       return purchaseRequisition_repository.save(purchaseRequisition);
    }

    public ResponseEntity<PurchaseRequisition> updatePUrchaseRequisition(PurchaseRequisition purchaseRequisition) {
        PurchaseRequisition purchaseRequisition1 = purchaseRequisition_repository.save(purchaseRequisition);
        return ResponseEntity.ok().body(purchaseRequisition1);
    }

    public ResponseEntity<?> deletePurchaseRequisition(Long id) {
        purchaseRequisition_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
