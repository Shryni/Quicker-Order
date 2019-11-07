package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.Invoice_Repository;
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

    public ResponseEntity<Invoice> addInvoice(Invoice invoice) throws URISyntaxException {
        Invoice invoice1 = invoice_repository.save(invoice);
        return ResponseEntity.created(new URI("/invoice/add/"+invoice1.getId())).body(invoice1);
    }

    public ResponseEntity<Invoice> getInvoice(long id) {
        Optional<Invoice> invoice = invoice_repository.findById(id);
        return invoice.map(invoice1 -> ResponseEntity.ok().body(invoice1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
