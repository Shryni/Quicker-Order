package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.*;
import com.nci.cad.quickerorder.payload.*;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.service.ApplyDiscount;
import com.nci.cad.quickerorder.service.Quotation_Comparator;
import com.nci.cad.quickerorder.service.Quotation_Service;
import com.nci.cad.quickerorder.service.VendorPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/quotation")
public class QuotationController {


    @Autowired
    Quotation_Service quotation_service;

    @Autowired
    Quotation_Repository quotation_repository;

    @Autowired
    VendorPRService vendorPRService;

    @Autowired
    Quotation_Comparator quotation_comparator;


    ResponseEntity responseEntity = null;


    @GetMapping("/all")
    public ResponseEntity<List<Quotation>> getAll(){
        List<Quotation> quotationList = quotation_service.getAll();
        if(quotationList != null){
            return responseEntity.status(HttpStatus.OK).body(quotationList);

        }
        else{
            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/allforRequestor")
    public ResponseEntity<List<QuotationResponse>> getAllForPR(@Valid @RequestBody Id id){
        List<QuotationResponse> quotationList = quotation_service.getAllForPR(id.getId());
        if(quotationList != null){
            return responseEntity.status(HttpStatus.OK).body(quotationList);

        }
        else{
            return (ResponseEntity<List<QuotationResponse>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/compare")
    public ResponseEntity<List<QuotationResponse>> compareQuotations(@Valid @RequestBody CompareRequest compareRequest ) throws ParseException {
        List<QuotationResponse> quotationList = null;
        if(compareRequest.getQuotationIDs().size()>3)
            return (ResponseEntity<List<QuotationResponse>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        else {
            List<Quotation> quotations = new ArrayList<Quotation>();
            ArrayList<Long> quotationIDs = compareRequest.getQuotationIDs();
            for (Long quotationID:quotationIDs
            ) {
                quotations.add(quotation_repository.findById(quotationID).get());
            }
            quotationList = quotation_comparator.compareQuotations(quotations,compareRequest.getCriteria());
            return responseEntity.status(HttpStatus.OK).body(quotationList);
        }
    }

    @GetMapping("/{quotationID}")
    public ResponseEntity<Quotation> getQuotationById(@PathVariable (value = "quotationID")Long quotationID) {
        Quotation quotation = quotation_service.getQuotationByID(quotationID);
        if (quotation != null) {
            return responseEntity.status(HttpStatus.OK).body(quotation);
        } else {
            return (ResponseEntity<Quotation>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/approve")
    public ResponseEntity<Quotation> approveQuotation (@Valid @RequestBody Id id){
        Quotation quotation = quotation_service.approveQuotation(id.getId());
        if(quotation != null){
            return responseEntity.status(HttpStatus.OK).body(quotation);
        }
        else {
            return (ResponseEntity<Quotation>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/getApproved")
    public ResponseEntity<List<VendorPR>> getApproved(@Valid @RequestBody Id id){
        List<VendorPR> approvedPRs = vendorPRService.findApprovedPR(id.getId());
        if(approvedPRs != null){
            return responseEntity.status(HttpStatus.OK).body(approvedPRs);
        }
        else {
            return (ResponseEntity<List<VendorPR>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/options")
    public ResponseEntity<List<String>> getOptions(){
        List<String> options = new ArrayList<String>();
        options.add(new String("Basic Transportation Cost"));
        options.add(new String("Fast Track Delivery"));
        options.add(new String("New Customer Discount"));
        options.add(new String("Regular Customer Discount"));
        return responseEntity.status(HttpStatus.OK).body(options);
     }

    @PostMapping("/new")
    public ResponseEntity<Quotation> addQuotation(@Valid @RequestBody NewQuotation newQuotation) throws URISyntaxException {
        Quotation quotation = quotation_service.addQuotation(newQuotation);
        if(quotation != null){
            return responseEntity.status(HttpStatus.OK).body(quotation);
        }
        else{
            return (ResponseEntity<Quotation>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/generateQuotationPrice")
    public ResponseEntity<Double> generateQuotationPrice(@Valid @RequestBody GeneratePrice generatePrice) throws URISyntaxException {
        Double price = quotation_service.generateQuotationPrice(generatePrice);
        if(price != null){
            return responseEntity.status(HttpStatus.OK).body(price);
        }
        else{
            return (ResponseEntity<Double>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuotation( @Valid @PathVariable Long id) {
        return quotation_service.deleteQuotation(id);
    }



}
