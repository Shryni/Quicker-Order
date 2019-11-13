package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRequisition_Repository extends JpaRepository<PurchaseRequisition,Long> {
    List<PurchaseRequisition> findByRequestorId(Long id);
}
