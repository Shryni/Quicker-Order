package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Item_Repository extends JpaRepository<Item , Long> {
    List<Item> findByPurchaseRequisitionId(Long id);
    List<Item> findByQuotationId(Long id);

}
