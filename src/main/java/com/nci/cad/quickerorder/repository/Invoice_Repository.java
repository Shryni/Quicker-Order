package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_Repository extends JpaRepository<Invoice, Long> {
}
