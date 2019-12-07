package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.model.Requestor;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Quotation_Repository extends JpaRepository<Quotation, Long> {
    //List<Quotation> findByPurchaseOrderId(Long id);
    List<Quotation> findByVendorPRId(Long id);

}
