package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.dto.RequestorDTO;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.User;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
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

    @GetMapping("/all")
    public String getAllRequestor(@ModelAttribute("userForm") User userForm, Model model){
        List<Requestor> requestors = requestor_service.getAllRequestors(userForm.getUsername());
        if(requestors != null){
            model.addAttribute("requestors", requestors);
            model.addAttribute("requestorStoreName",userForm.getUsername());
            return "th_viewAllRequestors";
        }
        else{
            model.addAttribute(null);
            return "";
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

    @PostMapping("/new")
    public String addRequestor(@ModelAttribute(name = "requestor") Requestor requestor,
                               @ModelAttribute(name = "requestorStoreName") String requestorStoreName,
                               Model model) throws URISyntaxException {
        Requestor requestor1 = requestor_service.addRequestor(requestor, requestorStoreName);
        if (requestor1 != null) {
            model.addAttribute("addedrequestor",requestor1);
            return "th_viewRequestor";
        } else {
            model.addAttribute(null);
            return "";
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