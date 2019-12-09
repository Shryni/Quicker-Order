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

    public VendorStore findByID(Long vendorstireID){
        return vendorStore_repository.findById(vendorstireID).get();
    }

    public VendorStore addVendorStore(VendorStore vendorStore){
        return vendorStore_repository.save(vendorStore);
    }

    public VendorStore updateVendorStore(VendorStore vendorStore){
        VendorStore vendorStore1 = vendorStore_repository.findById(vendorStore.getId()).get();
        return null;
    }
}
