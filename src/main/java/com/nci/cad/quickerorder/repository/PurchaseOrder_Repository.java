package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PurchaseOrder_Repository extends JpaRepository<PurchaseRequisition,Long> {
}
