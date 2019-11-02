package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.repository.PurchaseOrder_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class Purchaseorder_Service {
    @Autowired
    PurchaseOrder_Repository purchaseOrder_repository;

    public ResponseEntity<Purchaseorder> addPurchaseOrder(Purchaseorder purchaseOrder) throws URISyntaxException {
        Purchaseorder purchaseOrder1 = purchaseOrder_repository.save(purchaseOrder);
        return ResponseEntity.created(new URI("/purchaseOrder/add/"+purchaseOrder1.getId())).body(purchaseOrder1);
    }

    public ResponseEntity<Purchaseorder> getPurchaseOrder(long id) {
        Optional<Purchaseorder> purchaseOrder = purchaseOrder_repository.findById(id);
        return purchaseOrder.map(purchaseOrder1 -> ResponseEntity.ok().body(purchaseOrder1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Purchaseorder> updatePurchaseOrder(Purchaseorder purchaseOrder) {
        Purchaseorder purchaseOrder1 = purchaseOrder_repository.save(purchaseOrder);
        return ResponseEntity.ok().body(purchaseOrder1);
    }

    public ResponseEntity<?> deletePurchaseOrder(Long id) {
        purchaseOrder_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<Purchaseorder> getAll() {
        return purchaseOrder_repository.findAll();
    }
}
