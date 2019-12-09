package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Purchaseorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Invoice_Repository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByPurchaseorderId(Long id);
}
