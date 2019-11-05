package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.service.VendorStore_Service;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAll")
    public List<VendorStore> getAllVendorStore(){
        return vendorStore_service.getAllVendorStores();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<VendorStore> getVendorStore(@Valid @PathVariable long id){
        return vendorStore_service.getVendorStore(id);
    }

    @PostMapping("/add")
    public ResponseEntity<VendorStore> addVendorStore(@Valid @RequestBody VendorStore vendorStore) throws URISyntaxException{
        return vendorStore_service.addVendorStore(vendorStore);
    }

    @PutMapping ("/add/{id}")
    public ResponseEntity<VendorStore> updateVendorStore (@Valid @RequestBody VendorStore vendorStore){
        return vendorStore_service.updateVendorStore(vendorStore);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup( @Valid @PathVariable Long id) {
        return vendorStore_service.deleteVendorStore(id);
    }
}
