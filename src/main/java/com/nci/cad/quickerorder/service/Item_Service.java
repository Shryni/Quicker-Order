package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.repository.Item_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class Item_Service {

    @Autowired
    Item_Repository item_repository;

    @Autowired
    Requestor_Service requestor_service;

    public ResponseEntity<Item> addItem(Item item) throws URISyntaxException {
        Item item1 = item_repository.save(item);
        return ResponseEntity.created(new URI("/item/add/"+item1.getId())).body(item1);
    }

    public ResponseEntity<Item> getItem(long id) {
        Optional<Item> item = item_repository.findById(id);
        return item.map(item1 -> ResponseEntity.ok().body(item1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Item> updateItem(Item item) {
        Item item1 = item_repository.save(item);
        return ResponseEntity.ok().body(item1);
    }

    public ResponseEntity<?> deleteItem(Long id) {
        item_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<Item> getAllItems(Long requestorstoreId, Long requestorId, Long prId) {
        Requestor requestor = requestor_service.getRequestorById(requestorstoreId,requestorId);
        return null;
    }


}
