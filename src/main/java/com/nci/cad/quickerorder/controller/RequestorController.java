package com.nci.cad.quickerorder.controller;


import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.payload.Id;
import com.nci.cad.quickerorder.payload.NewRequestor;
import com.nci.cad.quickerorder.payload.Spending;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.Quotation_Service;
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
@RequestMapping("/requestor")
public class RequestorController {
    @Autowired
    Requestor_Service requestor_service;

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

    @Autowired
    Quotation_Service quotation_service;
    ResponseEntity responseEntity = null;

    //*************************************************************************//
    @GetMapping("/view")
    public String viewRequestor() {
        return "requestor/th_viewRequestorStore.html";
    }

    @GetMapping("/add")
    public String addRequestor(Model model,@RequestParam String requestorStoreName) {
        model.addAttribute("requestorStoreName",requestorStoreName);
        return "th_addRequestor.html";
    }

    @GetMapping("/edit")
    public String editRequestor() {
        return "requestor/edit.html";
    }

    //*************************************************************************//

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

    @PostMapping ("/all")
    public ResponseEntity<List<Requestor>> getAllRequestors(@Valid @RequestBody Id id){
        List<Requestor> requestor = requestor_service.getAllbyID(id.getId());
        if(requestor != null){
            return responseEntity.status(HttpStatus.OK).body(requestor);
        }
        else {
            return (ResponseEntity<List<Requestor>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/new")
    public ResponseEntity<Requestor> addRequestor(@Valid @RequestBody NewRequestor newRequestor) throws URISyntaxException {


        Requestor requestor1 = requestor_service.addRequestor(newRequestor);
        if (requestor1 != null) {
            return responseEntity.status(HttpStatus.OK).body(requestor1);
        } else {
            return (ResponseEntity<Requestor>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
//    @GetMapping("/getPurchases/{requestorID}")
//    public ResponseEntity<List<Spending>> getRequestorPurchaseDetails(
//            @PathVariable(value = "requestorID") Long requestorID) {
//
//        System.out.println("Requested requestor id = " +requestorID);
//        List<Spending> spendings = quotation_service.getSpendingsByRequestors(requestorID,
//                Quotation.APPROVED_STATUS);
//
//        System.out.println(spendings);
//        if (spendings != null) {
//            return responseEntity.status(HttpStatus.OK).body(spendings);
//        } else {
//            return (ResponseEntity<List<Spending>>) responseEntity.status(HttpStatus.BAD_REQUEST);
//        }
//    }



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