package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.service.Purchaseorder_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/purchaseorder")
public class PurchaseorderController {
    @Autowired
    Purchaseorder_Service purchaseorder_service;

    @GetMapping("/view")
    public String viewPurchaseorder() {
        return "purchaseorder/view.html";
    }

    @GetMapping("/add")
    public String addPurchaseorder() {
        return "purchaseorder/add.html";
    }

    @GetMapping("/edit")
    public String editPurchaseorder() {
        return "purchaseorder/edit.html";
    }

    @GetMapping("/getAll")
    public List<Purchaseorder> getAll(){
        return purchaseorder_service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Purchaseorder> getPurchaseOrder(@Valid @PathVariable long id){
        return purchaseorder_service.getPurchaseOrder(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Purchaseorder> addPurchaseOrder(@Valid @RequestBody Purchaseorder purchaseorder) throws URISyntaxException {
        return purchaseorder_service.addPurchaseOrder(purchaseorder);
    }

    @PutMapping ("/add/{id}")
    public ResponseEntity<Purchaseorder> updatePurchaseOrder (@Valid @RequestBody Purchaseorder purchaseorder){
        return purchaseorder_service.updatePurchaseOrder(purchaseorder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePurchaseOrder( @Valid @PathVariable Long id) {
        return purchaseorder_service.deletePurchaseOrder(id);
    }
}
