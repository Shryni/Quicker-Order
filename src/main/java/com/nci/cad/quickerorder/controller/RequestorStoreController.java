package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.service.RequestorStore_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/requestorStore")
public class RequestorStoreController {

    @Autowired
    RequestorStore_Service requestorStore_service;

    @GetMapping("/getAll")
    public List<RequestorStore> getAllRequestorStore(){
        return requestorStore_service.getAllRequestorStores();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RequestorStore> getRequestorStore(@Valid @PathVariable long id){
        return requestorStore_service.getRequestorStore(id);
    }

    @PostMapping("/add")
    public ResponseEntity<RequestorStore> addRequestorStore(@Valid @RequestBody RequestorStore requestorStore) throws URISyntaxException{
        return requestorStore_service.addRequestorStore(requestorStore);
    }

   @PutMapping ("/add/{id}")
    public ResponseEntity<RequestorStore> updateRequestorStore (@Valid @RequestBody RequestorStore requestorStore){
        return requestorStore_service.updateRequestorStore(requestorStore);
   }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup( @Valid @PathVariable Long id) {
        return requestorStore_service.deleteRequestorStore(id);
    }
}