package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.Invoice_Repository;
import com.nci.cad.quickerorder.repository.PurchaseOrder_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Invoice_Service {
    @Autowired
    Invoice_Repository invoice_repository;

    @Autowired
    PurchaseOrder_Repository purchaseOrder_repository;

    public Invoice addInvoice(Long poID,Invoice invoice) throws URISyntaxException {
        Purchaseorder purchaseorder = purchaseOrder_repository.findById(poID).get();
        invoice.setPurchaseorder(purchaseorder);
        return invoice_repository.save(invoice);
    }

    public Invoice getInvoice(long id) {
        return invoice_repository.findById(id).get();
    }

    public ResponseEntity<Invoice> updateInvoice(Invoice invoice) {
        Invoice invoice1 = invoice_repository.save(invoice);
        return ResponseEntity.ok().body(invoice1);
    }

    public ResponseEntity<?> deleteInvoice(Long id) {
        invoice_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<Invoice> getAll() {
        return invoice_repository.findAll();
    }


}
