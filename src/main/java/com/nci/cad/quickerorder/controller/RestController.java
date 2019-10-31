package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.service.Item_Service;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.RequestorStore_Service;
import com.nci.cad.quickerorder.service.Requestor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/quickerorder")
public class RestController {

    @Autowired
    Item_Service item_service;

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

    @Autowired
    Requestor_Service requestor_service;

    @Autowired
    RequestorStore_Service requestorStore_service;

    @GetMapping("/getAllRequestorStore")
    List<RequestorStore> getAllRequestorStore(){
        return requestorStore_service.getAllRequestorStores();
    }

    @PostMapping("/addRequestorStore")
    ResponseEntity<RequestorStore> addRequestorStore(@Valid @RequestBody RequestorStore requestorStore) throws URISyntaxException{
        return requestorStore_service.addRequestorStore(requestorStore);
    }

   @PutMapping ("/addRequestorStore/{id}")
    ResponseEntity<RequestorStore> updateRequestorStore (@Valid @RequestBody RequestorStore requestorStore){
        return requestorStore_service.updateRequestorStore(requestorStore);
   }



}
