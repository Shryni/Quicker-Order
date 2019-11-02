package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/purchaseRequisition")
public class PurchaseRequisitionController {

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

    @GetMapping("/getAll")
    public List<PurchaseRequisition> getAll(){
        return purchaseRequisition_service.getAll();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<PurchaseRequisition> getPurchaseRequisition (@Valid @PathVariable Long id){
        return purchaseRequisition_service.getPurchaseRequistion(id);
    }
    @PostMapping("/add")
    public ResponseEntity<PurchaseRequisition> addPurchaseRequisition (@Valid @RequestBody PurchaseRequisition purchaseRequisition)throws URISyntaxException {
        return purchaseRequisition_service.addPurchaseRequisition(purchaseRequisition);
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<PurchaseRequisition> updatePUrchaseRequisition(@Valid @RequestBody PurchaseRequisition purchaseRequisition){
        return purchaseRequisition_service.updatePUrchaseRequisition(purchaseRequisition);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePurchaseRequisition (@Valid @PathVariable Long id){
        return purchaseRequisition_service.deletePurchaseRequisition(id);
    }

}