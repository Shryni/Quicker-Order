package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.dto.RequestorDTO;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
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
@RequestMapping("/requestor")
public class RequestorController {
    @Autowired
    Requestor_Service requestor_service;

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

    ResponseEntity responseEntity = null;

    //*************************************************************************//
    @GetMapping("/view")
    public String viewRequestor() {
        return "requestor/view.html";
    }

    @GetMapping("/add")
    public String addRequestor() {
        return "requestor/add.html";
    }

    @GetMapping("/edit")
    public String editRequestor() {
        return "requestor/edit.html";
    }

    //*************************************************************************//

    @GetMapping("/all")
    public ResponseEntity<List<Requestor>> getAllRequestor(){
        List<Requestor> requestors = requestor_service.getAll();
        if(requestors != null){
            return responseEntity.status(HttpStatus.OK).body(requestors);
        }
        else{
            return (ResponseEntity<List<Requestor>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{requestorId}")
    public ResponseEntity<Requestor> getRequestorById(@PathVariable (value = "requestorId")Long requestorId){
        Requestor requestor = requestor_service.getRequestorById(requestorId);
        if(requestor != null){
            return responseEntity.status(HttpStatus.OK).body(requestor);
        }
        else {
            return (ResponseEntity<Requestor>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{requestorstoreId}/new")
    public ResponseEntity<Requestor> addRequestor(@PathVariable (value = "requestorstoreId") Long requestorstoreId, @Valid @RequestBody Requestor requestor) throws URISyntaxException {
        Requestor requestor1 = requestor_service.addRequestor(requestor, requestorstoreId);
        if (requestor1 != null) {
            return responseEntity.status(HttpStatus.OK).body(requestor1);
        } else {
            return (ResponseEntity<Requestor>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/{requestorID}/pRequisitions")
    public ResponseEntity<List<PurchaseRequisition>> getAllPR(@PathVariable (value = "requestorID") Long requestorID){
        List<PurchaseRequisition> purchaseRequisitionList = purchaseRequisition_service.getPRByRequestorID(requestorID);
        if(purchaseRequisitionList != null){
            return responseEntity.status(HttpStatus.OK).body(purchaseRequisitionList);
        }
        else{
            return (ResponseEntity<List<PurchaseRequisition>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRequestor(@Valid @PathVariable Long id) {
        return requestor_service.deleteRequestor(id);
    }
}