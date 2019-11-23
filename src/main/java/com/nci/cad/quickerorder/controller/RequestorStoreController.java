package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.service.RequestorStore_Service;
import com.nci.cad.quickerorder.service.Requestor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//    @GetMapping("/view")
//    public String viewRequestorstore() {
//        return "requestorstore/th_viewRequestorStore.html";
//    }
    @GetMapping("/view/{id}")
    public String viewRequestorstore(Model model, @PathVariable("id") String id) {
        model.addAttribute("requestorStore", requestorStore_service.getRequestorStore(Long.parseLong(id)));
        return "th_viewRequestorStore";
    }

    @GetMapping("/add")
    public String addReqestorstore() {
        return "th_addRequestorStore";
    }

    @GetMapping("/edit")
    public String editRequestorstore() {
        return "requestorstore/edit.html";
    }
    //-------------------------------------------------------------------------

    @GetMapping("/all")
    public String getAllRequestorStore(Model model){
        List<RequestorStore> requestorStores = requestorStore_service.getAllRequestorStores();
        //System.out.println(requestorStores.get(0).toString());
        if (requestorStores != null) {
            model.addAttribute("allrequestorStores",requestorStores);
            return "th_viewAllRequestorStore.html";
        } else {
            model.addAttribute(null);
            return "";
        }
    }
    @PostMapping("/new")
    public String newRequestorStore(@ModelAttribute(name = "requestorStore")RequestorStore requestorStore, Model model) throws URISyntaxException {
        RequestorStore requestorStoreAdded = requestorStore_service.addRequestorStore(requestorStore);
        if(requestorStoreAdded != null){
            model.addAttribute("reqStore",requestorStoreAdded);
            return "RequestorStore/th_viewRequestorStore.html";
        }
        else{
            model.addAttribute(null);
            return "";
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


//    public String addRequestorStore(@Valid RequestorStore requestorStore) throws URISyntaxException{
//        RequestorStore requestorStoreAdded = requestorStore_service.addRequestorStore(requestorStore);
//
//    }
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
