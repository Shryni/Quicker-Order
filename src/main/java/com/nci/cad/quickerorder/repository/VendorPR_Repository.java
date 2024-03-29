package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.VendorPR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorPR_Repository extends JpaRepository<VendorPR, Long> {

    List<VendorPR> findByVendorStore_id(Long id);
    List<VendorPR> findBypurchaseRequisition_id(Long id);
//TODO

}
