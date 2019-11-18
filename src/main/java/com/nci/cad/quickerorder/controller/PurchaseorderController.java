package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.service.Purchaseorder_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/purchaseorder")
public class PurchaseorderController {
    @Autowired
    Purchaseorder_Service purchaseorder_service;

    ResponseEntity responseEntity = null;

    @GetMapping("/all")
    public ResponseEntity<List<Purchaseorder>> getAll(){
        List<Purchaseorder> purchaseorders = purchaseorder_service.getAll();
        if(purchaseorders != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseorders);
        }
        else{
            return (ResponseEntity<List<Purchaseorder>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{purchaseOrderID}")
    public ResponseEntity<Purchaseorder> getPOByID(@PathVariable (value = "purchaseOrderID")Long purchaseOrderID){
        Purchaseorder purchaseorder = purchaseorder_service.getPOByID(purchaseOrderID);
        if(purchaseorder != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseorder);
        }
        else {
            return (ResponseEntity<Purchaseorder>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{quotationID}/new")
    public ResponseEntity<Purchaseorder> addPO(@PathVariable (value = "quotationID") Long quotationID, @Valid @RequestBody Purchaseorder purchaseorder) throws URISyntaxException {
        Purchaseorder purchaseorder1 = purchaseorder_service.addPurchaseOrder(quotationID,purchaseorder);
        if(purchaseorder1 != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseorder1);
        }
        else{
            return (ResponseEntity<Purchaseorder>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
}
