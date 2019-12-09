package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.PurchaseOrder_Repository;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
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

    @Autowired
    Quotation_Repository quotation_repository;

    public List<Purchaseorder> getAll() {
        return purchaseOrder_repository.findAll();
    }

    public Purchaseorder getPOByID(long id) {
        return purchaseOrder_repository.findById(id).get();
    }

    public Purchaseorder addPurchaseOrder(Long quotationID,Purchaseorder purchaseOrder) throws URISyntaxException {
        Quotation quotation = quotation_repository.findById(quotationID).get();
        if(quotation.getStatus()){
            purchaseOrder.setQuotation(quotation);
            return purchaseOrder_repository.save(purchaseOrder);
        }
        else{
            System.out.println("Quotation not approved");
            return null;
        }

    }

    public ResponseEntity<Purchaseorder> updatePurchaseOrder(Purchaseorder purchaseOrder) {
        Purchaseorder purchaseOrder1 = purchaseOrder_repository.save(purchaseOrder);
        return ResponseEntity.ok().body(purchaseOrder1);
    }

    public ResponseEntity<?> deletePurchaseOrder(Long id) {
        purchaseOrder_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
