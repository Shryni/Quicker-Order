package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.Requestor_Service;
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

    @Autowired
    Requestor_Service requestor_service;


    @GetMapping("/{requestorstoreId}/getRequestor/{requestorId}/getPR")
    public List<PurchaseRequisition> getAllPR(@PathVariable (value = "requestorstoreId")Long requestorstoreId,@PathVariable (value = "requestorId")Long requestorId) {
       return purchaseRequisition_service.getAllPR(requestorstoreId,requestorId);
    }
    @GetMapping("/{requestorstoreId}/getRequestor/{requestorId}/getPR/{prId}")
    public PurchaseRequisition getPurchaseRequisition (@PathVariable (value = "requestorstoreId")Long requestorstoreId,@PathVariable (value = "requestorId")Long requestorId,@PathVariable (value = "requestorId")Long prId){
        return purchaseRequisition_service.getPurchaseRequistionbyID(requestorstoreId,requestorId,prId);
    }

    @PostMapping("/{requestorstoreId}/getRequestor/{requestorId}/addPR")
    public PurchaseRequisition addPR(@PathVariable (value = "requestorstoreId")Long requestorstoreId, @PathVariable (value = "requestorId")Long requestorId, @Valid @RequestBody PurchaseRequisition purchaseRequisition) throws URISyntaxException {
        return purchaseRequisition_service.addPurchaseRequisition(requestorstoreId,requestorId,purchaseRequisition);
    }
    /*@PostMapping("/{requestorstoreId}/addRequestor")
    public Requestor addRequestor(@PathVariable (value = "requestorstoreId") Long requestorstoreId,@Valid @RequestBody Requestor requestor) throws URISyntaxException {
        return requestor_service.addRequestor(requestor,requestorstoreId);

    } */

    @PutMapping("/add/{id}")
    public ResponseEntity<PurchaseRequisition> updatePUrchaseRequisition(@Valid @RequestBody PurchaseRequisition purchaseRequisition){
        return purchaseRequisition_service.updatePUrchaseRequisition(purchaseRequisition);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePurchaseRequisition (@Valid @PathVariable Long id){
        return purchaseRequisition_service.deletePurchaseRequisition(id);
    }

}
