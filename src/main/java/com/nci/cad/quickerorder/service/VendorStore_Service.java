package com.nci.cad.quickerorder.service;


import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.repository.VendorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@Service
public class VendorStore_Service {
    @Autowired
    VendorStore_Repository vendorStore_repository;

    public List<VendorStore> getAllVendorStores() {
        return vendorStore_repository.findAll();
    }

    public ResponseEntity<VendorStore> addVendorStore(VendorStore vendorStore) throws URISyntaxException {
        VendorStore vendorStore1 = vendorStore_repository.save(vendorStore);
        return ResponseEntity.created(new URI("/vendorstore/add/" + vendorStore1.getId()))
                .body(vendorStore1);
    }

    public ResponseEntity<VendorStore> updateVendorStore(VendorStore vendorStore) {
        VendorStore vendorStore1 = vendorStore_repository.save(vendorStore);
        return ResponseEntity.ok().body(vendorStore1);
    }

    public ResponseEntity<VendorStore> getVendorStore(long id) {
        Optional<VendorStore> vendorStore = vendorStore_repository.findById(id);
        return vendorStore.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> deleteVendorStore(Long id) {
        vendorStore_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
