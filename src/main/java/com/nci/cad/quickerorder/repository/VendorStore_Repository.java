package com.nci.cad.quickerorder.repository;


import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.model.VendorStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorStore_Repository extends JpaRepository<VendorStore,Long> {
    // Group findByName(String name);
}