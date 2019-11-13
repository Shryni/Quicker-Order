package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.service.Item_Service;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller

@RequestMapping("/item")
public class ItemController {

    @Autowired
    Item_Service item_service;

    @Autowired
    PurchaseRequisition_Service purchaseRequisition_service;

//    @GetMapping("/view")
//    public String viewItems() {
//        return "items/view.html";
//    }
//
//    @GetMapping("/add")
//    public String addItems() {
//        return "items/add.html";
//    }
//
//    @GetMapping("/edit")
//    public String editItems() {
//        return "items/add.html";
//    }


    @GetMapping("/{requestorstoreId}/getRequestor/{requestorId}/getPR/{prId}/")
    public List<Item> getAllItems(@PathVariable (value = "requestorstoreId")Long requestorstoreId,@PathVariable (value = "requestorId")Long requestorId,@PathVariable (value = "prId")Long prId) {
        return item_service.getAllItems(requestorstoreId,requestorId,prId);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItem(@Valid @PathVariable long id){
        return item_service.getItem(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) throws URISyntaxException {
        return item_service.addItem(item);
    }

   @PutMapping ("/add/{id}")
    public ResponseEntity<Item> updateItem (@Valid @RequestBody Item item){
        return item_service.updateItem(item);
   }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem( @Valid @PathVariable Long id) {
        return item_service.deleteItem(id);
    }
}
