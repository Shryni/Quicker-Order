package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.payload.Id;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import com.nci.cad.quickerorder.service.VendorPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vpr")
public class VendorPRController {

    ResponseEntity responseEntity = null;

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    @Autowired
    VendorPRService vendorPRService;


    @PostMapping("/all")
    public ResponseEntity <List<VendorPR>> getAllVPR(@Valid @RequestBody Id id){

        List<VendorPR> vendorPRS = vendorPR_repository.findByVendorStore_id(id.getId());
        System.out.println(id.getId());
        System.out.println("UIUIUIUI "+vendorPRS);
        for (VendorPR vpr:
                vendorPRS ) {
            String requestor = purchaseRequisition_repository.findById(vpr.getId()).get().getRequestor().getRequestorStore().getName();
            vpr.setRequestor(requestor);
        }
        if(vendorPRS != null){
            return responseEntity.status(HttpStatus.OK).body(vendorPRS);
        }
        else{
            return (ResponseEntity <List<VendorPR>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/accept")
    public ResponseEntity<VendorPR> approvePR(@Valid @RequestBody Id id){
        VendorPR vpr = vendorPRService.approveVendorPR(id.getId());
        if(vpr != null){
            return responseEntity.status(HttpStatus.OK).body(vpr);
        }
        else{
            return (ResponseEntity<VendorPR>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

}
