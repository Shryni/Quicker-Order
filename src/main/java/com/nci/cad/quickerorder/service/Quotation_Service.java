package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.exit;
import static java.lang.System.setOut;

@Service
public class Quotation_Service {
    @Autowired
    Quotation_Repository quotation_repository;

    public ResponseEntity<Quotation> addQuotation(Quotation quotation) throws URISyntaxException {
        Quotation quotation1 = quotation_repository.save(quotation);
        return ResponseEntity.created(new URI("/quotation/add/"+quotation1.getId())).body(quotation1);
    }

    public ResponseEntity<Quotation> getQuotation(long id) {
        Optional<Quotation> quotation = quotation_repository.findById(id);
        return quotation.map(quotation1 -> ResponseEntity.ok().body(quotation1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Quotation> updateQuotation(Quotation quotation) {
        Quotation quotation1 = quotation_repository.save(quotation);
        return ResponseEntity.ok().body(quotation1);
    }

    public ResponseEntity<?> deleteQuotation(Long id) {
        quotation_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<Quotation> getAll() {
        return quotation_repository.findAll();
    }
}
