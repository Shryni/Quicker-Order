package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.VendorPR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorPR_Repository extends JpaRepository<VendorPR, Long> {
}
