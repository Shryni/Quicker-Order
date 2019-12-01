package com.nci.cad.quickerorder.repository;


import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.model.VendorStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorStore_Repository extends JpaRepository<VendorStore,Long> {

    Optional<VendorStore> findByEmail(String vendoremail);

    Optional<VendorStore> findByUsernameOrEmail(String vendorStoreName, String vendoremail);

    List<VendorStore> findByIdIn(List<Long> userIds);

    Optional<VendorStore> findByUsername(String vendorStoreName);

    Optional<VendorStore> findByName(String vendorStoreName);

    Boolean existsByUsername(String vendorStoreName);

    Boolean existsByEmail(String vendoremail);

}
