package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
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

    @Autowired
    VendorPR_Repository vendorPR_repository;

    public List<Quotation> getAll() {
        return quotation_repository.findAll();
    }
    public Quotation getQuotationByID(long id) {
        return quotation_repository.findById(id).get();
    }

    public Quotation addQuotation(Long vendorPRID, Quotation quotation) throws URISyntaxException {
        VendorPR vendorPR = vendorPR_repository.findById(vendorPRID).get();
        quotation.setVendorPR(vendorPR);
        return quotation_repository.save(quotation);
    }
    public List<Quotation> getAllQuotationsforVendor(Long prID) {
        return quotation_repository.findByVendorPRId(prID);
    }

    public Quotation approveQuotation(Long quotationID) {
        Quotation quotation = quotation_repository.findById(quotationID).get();
        quotation.setStatus(true);
        return quotation_repository.save(quotation);
    }
    public ResponseEntity<?> deleteQuotation(Long id) {
        quotation_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
