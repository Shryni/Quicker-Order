package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
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
            Requestor_Service requestor_service;

    public Requestor getRequestor(Long requestorstoreId, Long requestorId){
        return  requestor_service.getRequestorById(requestorstoreId,requestorId);
    }

    public List<PurchaseRequisition> getAllPR(Long requestorstoreId, Long requestorId) {
        Requestor requestor = getRequestor(requestorstoreId,requestorId);
        List<PurchaseRequisition> purchaseRequisitionList = purchaseRequisition_repository.findByRequestorId(requestor.getId());
        return purchaseRequisitionList;
    }
    public PurchaseRequisition getPurchaseRequistionbyID(Long requestorstoreId,Long requestorId, Long prId) {
        PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.findById(prId).get();
        return purchaseRequisition;
    }

   public PurchaseRequisition addPurchaseRequisition(Long requestorstoreId,Long requestorId, PurchaseRequisition purchaseRequisition) throws URISyntaxException {
       Requestor requestor = getRequestor(requestorstoreId,requestorId);
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
