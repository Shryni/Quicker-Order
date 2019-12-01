package com.nci.cad.quickerorder.repository;



import com.nci.cad.quickerorder.model.VendorStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface
VendorStore_Repository extends JpaRepository<VendorStore,Long> {
    Optional<VendorStore> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
