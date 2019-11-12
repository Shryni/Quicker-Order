package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
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

    public List<PurchaseRequisition> getAll() {
        return purchaseRequisition_repository.findAll();
    }

    public ResponseEntity<PurchaseRequisition> getPurchaseRequistion(Long id) {
        Optional<PurchaseRequisition> purchaseRequisition = purchaseRequisition_repository.findById(id);
        return purchaseRequisition.map(purchaseRequisition1 -> ResponseEntity.ok().body(purchaseRequisition1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<PurchaseRequisition> addPurchaseRequisition(PurchaseRequisition purchaseRequisition) throws URISyntaxException {
        PurchaseRequisition purchaseRequisition1 = purchaseRequisition_repository.save(purchaseRequisition);
        return ResponseEntity.created(new URI("/purchaserequisition/add/"+purchaseRequisition1.getId())).body(purchaseRequisition1);
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
