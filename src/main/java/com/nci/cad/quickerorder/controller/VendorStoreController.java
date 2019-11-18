package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.service.VendorStore_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/vendorstore")
public class VendorStoreController {
    @Autowired
    VendorStore_Service vendorStore_service;

    ResponseEntity responseEntity = null;

    @GetMapping("/all")
    public ResponseEntity<List<VendorStore>> getAllVendorStores(){
        List<VendorStore> vendorStores = vendorStore_service.getAllVendorStores();
        if(vendorStores != null){
            return responseEntity.status(HttpStatus.OK).body(vendorStores);
        }
        else{
            return (ResponseEntity<List<VendorStore>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorStore> getVendorStorebyID(@Valid @PathVariable long id){
        VendorStore vendorStore = vendorStore_service.findByID(id);
        if(vendorStore != null){
            return responseEntity.status(HttpStatus.OK).body(vendorStore);
        }
        else{
            return (ResponseEntity<VendorStore>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<VendorStore> addVendorStore(@Valid @RequestBody VendorStore vendorStore) throws URISyntaxException{
        VendorStore vendorStore1 = vendorStore_service.addVendorStore(vendorStore);
        if(vendorStore != null){
            return responseEntity.status(HttpStatus.OK).body(vendorStore);
        }
        else{
            return (ResponseEntity<VendorStore>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup( @Valid @PathVariable Long id) {
        //return vendorStore_service.deleteVendorStore(id);
        return null;
    }
}
