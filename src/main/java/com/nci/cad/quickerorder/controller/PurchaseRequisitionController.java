package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.service.Item_Service;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.VendorPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/purchaseRequisition")
public class PurchaseRequisitionController {

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

    @Autowired
    VendorPRService vendorPRService;

    @Autowired
    Item_Service item_service;

    ResponseEntity responseEntity = null;

    //****************************************************************************//
    @GetMapping("/view")
    public String viewPurchaserequisition() {
        return "purchaserequisition/view.html";
    }

    @GetMapping("/add")
    public String addPurchaserequisition() {

        return "purchaserequisition/add.html";
    }

    @PatchMapping("/edit")
    public String editPurchaserequisition() {
        return "purchaserequisition/edit.html";
    }
    //****************************************************************************//

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseRequisition>> getAllPR() {
        List<PurchaseRequisition> purchaseRequisitionList = purchaseRequisition_service.getAllPR();
        if (purchaseRequisitionList != null) {
            return responseEntity.status(HttpStatus.OK).body(purchaseRequisitionList);
        } else {
            return (ResponseEntity<List<PurchaseRequisition>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{prID}")
    public ResponseEntity<PurchaseRequisition> getPRByID(@PathVariable (value = "prID") Long prID){
        PurchaseRequisition purchaseRequisition = purchaseRequisition_service.getPRByID(prID);
        if(purchaseRequisition != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseRequisition);
        }
        else {
            return (ResponseEntity<PurchaseRequisition>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/{requestorId}/new")
    public ResponseEntity<PurchaseRequisition> addPR(@PathVariable (value = "requestorId") Long requestorId, @Valid @RequestBody PurchaseRequisition purchaseRequisition) throws URISyntaxException {
        PurchaseRequisition purchaseRequisition1 = purchaseRequisition_service.addPurchaseRequisition(requestorId,purchaseRequisition);
        if(purchaseRequisition1 != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseRequisition1);
        }
        else{
            return (ResponseEntity<PurchaseRequisition>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/{prID}/items")
    public ResponseEntity<List<Item>> getAllItems(@PathVariable (value = "prID") Long prID){
        List<Item> items = item_service.getItemsByPRId(prID);
        if(items != null){
            return responseEntity.status(HttpStatus.OK).body(items);
        }
        else{
            return (ResponseEntity<List<Item>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{prID}/export")
    public String sendPRToVendor(@PathVariable (value = "prID") Long prID, Long[] vendors){
        return vendorPRService.addPRsToVendors(prID,vendors);
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
