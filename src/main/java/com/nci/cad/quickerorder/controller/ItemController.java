package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.service.Item_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    Item_Service item_service;

    @GetMapping("/getAll")
    public List<Item> getAll(){
        return item_service.getAll();
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
