package com.nci.cad.quickerorder.controller;

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
    public List<RequestorStore> getAllRequestorStore(){
        return requestorStore_service.getAllRequestorStores();
    }

    @GetMapping("/getRequestorStore/{id}")
    public ResponseEntity<RequestorStore> getRequestorStore(@Valid @PathVariable long id){
        return requestorStore_service.getRequestorStore(id);
    }

    @PostMapping("/addRequestorStore")
    public ResponseEntity<RequestorStore> addRequestorStore(@Valid @RequestBody RequestorStore requestorStore) throws URISyntaxException{
        return requestorStore_service.addRequestorStore(requestorStore);
    }

   @PutMapping ("/addRequestorStore/{id}")
    public ResponseEntity<RequestorStore> updateRequestorStore (@Valid @RequestBody RequestorStore requestorStore){
        return requestorStore_service.updateRequestorStore(requestorStore);
   }

    @DeleteMapping("/deleteRequestorStore/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        return requestorStore_service.deleteRequestorStore(id);
    }

}
