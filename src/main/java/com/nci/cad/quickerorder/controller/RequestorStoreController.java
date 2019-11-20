package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.service.RequestorStore_Service;
import com.nci.cad.quickerorder.service.Requestor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/requestorStore")
public class RequestorStoreController {

    @Autowired
    RequestorStore_Service requestorStore_service;

    @Autowired
    Requestor_Service requestor_service;


    ResponseEntity responseEntity = null;

    //-------------------------------------------------------------------------
    @GetMapping("/view")
    public String viewRequestorstore() {
        return "requestorstore/view.html";
    }

    @GetMapping("/add")
    public String addReqestorstore() {
        return "RequestorStore/add.html";
    }

    @GetMapping("/edit")
    public String editRequestorstore() {
        return "requestorstore/edit.html";
    }
    //-------------------------------------------------------------------------

    @GetMapping("/all")
    public ResponseEntity<List<RequestorStore>> getAllRequestorStore(){
        List<RequestorStore> requestorStores = requestorStore_service.getAllRequestorStores();
        //System.out.println(requestorStores.get(0).toString());
        if (requestorStores != null) {
            return responseEntity.status(HttpStatus.OK).body(requestorStores);
        } else {
            return (ResponseEntity<List<RequestorStore>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<RequestorStore> getRequestorStore(@Valid @PathVariable long id){
        RequestorStore requestorStore = requestorStore_service.getRequestorStore(id);
        if(requestorStore != null){
            return responseEntity.status(HttpStatus.OK).body(requestorStore);
        }
        else{
            return (ResponseEntity<RequestorStore>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new")
    public String addRequestorStore(@Valid RequestorStore requestorStore) throws URISyntaxException{
        RequestorStore requestorStoreAdded = requestorStore_service.addRequestorStore(requestorStore);
        if(requestorStoreAdded != null){
            return "RequestorStore/add.html";
        }
        else{
            return "";
        }
    }
    @GetMapping("/{requestorstoreId}/requestors")
    public ResponseEntity<List<Requestor>> getAll(@PathVariable (value = "requestorstoreId")Long requestorstoreId) {
        List<Requestor> requestors = requestor_service.getRequestorByStoreID(requestorstoreId);
        if(requestors != null){
            return responseEntity.status(HttpStatus.OK).body(requestors);
        }
        else{
            return (ResponseEntity<List<Requestor>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping ("/update/{id}")
//    public ResponseEntity<RequestorStore> updateRequestorStore (@Valid @RequestBody RequestorStore requestorStore){
//        return requestorStore_service.updateRequestorStore(requestorStore);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteGroup( @Valid @PathVariable Long id) {
//        return requestorStore_service.deleteRequestorStore(id);
//    }

}
