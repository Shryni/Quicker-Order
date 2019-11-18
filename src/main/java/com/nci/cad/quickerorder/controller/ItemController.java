package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.service.Item_Service;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    ResponseEntity responseEntity = null;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = item_service.getAllItems();
        if(items != null){
            return responseEntity.status(HttpStatus.OK).body(items);
        }
        else {
            return (ResponseEntity<List<Item>>)responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{itemID}")
    public ResponseEntity<Item> getItembyID(@PathVariable (value = "itemID") Long itemID){
        Item item = item_service.getItembyID(itemID);
        if(item != null){
            return responseEntity.status(HttpStatus.OK).body(item);
        }
        else {
            return (ResponseEntity<Item>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{prID}/new")
    public ResponseEntity<Item> addItemtoPR(@PathVariable (value = "prID") Long prID, @Valid @RequestBody Item item) throws URISyntaxException {
        Item item1 = item_service.addnewItem(prID,item);
        if(item1 != null){
            return responseEntity.status(HttpStatus.OK).body(item1);
        }
        else{
            return (ResponseEntity<Item>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

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
