package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Purchaseorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PurchaseOrder_Repository extends JpaRepository<Purchaseorder,Long> {
}
