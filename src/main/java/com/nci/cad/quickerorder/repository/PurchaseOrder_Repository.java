package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Purchaseorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrder_Repository extends JpaRepository<Purchaseorder,Long> {
    //List<Purchaseorder> findByPurchaseRequisitionId(Long id);
    Purchaseorder findByQuotationId(Long id);
}
