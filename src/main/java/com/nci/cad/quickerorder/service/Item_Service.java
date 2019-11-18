package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.repository.Item_Repository;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
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
    PurchaseRequisition_Repository purchaseRequisition_repository;

    public List<Item> getItemsByPRId( Long prId) {
        List<Item> items = item_repository.findByPurchaseRequisitionId(prId);
        return items;
    }
    public List<Item> getAllItems(){
        return item_repository.findAll();
    }
    public Item getItembyID(Long itemID){
        return item_repository.findById(itemID).get();
    }
    public Item addnewItem(Long prID, Item item){
        PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.findById(prID).get();
        item.setPurchaseRequisition(purchaseRequisition);
        return item_repository.save(item);
    }

    public ResponseEntity<Item> updateItem(Item item) {
        Item item1 = item_repository.save(item);
        return ResponseEntity.ok().body(item1);
    }

    public ResponseEntity<?> deleteItem(Long id) {
        item_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
