package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.*;
import com.nci.cad.quickerorder.payload.GeneratePrice;
import com.nci.cad.quickerorder.payload.Id;
import com.nci.cad.quickerorder.payload.JwtAuthenticationResponse;
import com.nci.cad.quickerorder.payload.NewQuotation;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
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
    VendorPR_Repository vendorPR_repository;

    @Autowired
    VendorPRService vendorPRService;


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
    public ResponseEntity<List<Quotation>> getAllForRequestor(@Valid @RequestBody Id id){
        List<Quotation> quotationList = quotation_service.getAllForRequestor(id.getId());
        if(quotationList != null){
            return responseEntity.status(HttpStatus.OK).body(quotationList);

        }
        else{
            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{prID}/all")
    public ResponseEntity<List<Quotation>> getAllQuotationforthisRequestor(@PathVariable (value = "prID")Long prID){
        List<Quotation> quotationList = quotation_service.getQuotationsbyprID(prID);
        if(quotationList != null){
            return responseEntity.status(HttpStatus.OK).body(quotationList);
        }
        else{
            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
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


    @PutMapping("/{quotationID}/approve")
    public ResponseEntity<Quotation> approveQuotation (@PathVariable (value = "quotationID")Long quotationID){
        Quotation quotation = quotation_service.approveQuotation(quotationID);
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
        Quotation quotation1 = quotation_service.addQuotation(newQuotation);
        if(quotation1 != null){
            return responseEntity.status(HttpStatus.OK).body(quotation1);
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

//    @GetMapping("/compare/{criteria}")
//    public ResponseEntity<List<Quotation>> compareQuotations(@Valid @RequestBody List<Quotation> quotations ,@PathVariable String criteria) throws ParseException {
//        List<Quotation> quotationList = null;
//        if(quotations.size()>3)
//            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
//        else
//            quotationList = quotation_comparator.compareQuotations(quotations,criteria);
//            return responseEntity.status(HttpStatus.OK).body(quotationList);
//    }
//    @GetMapping("/compare/{criteria}")
//    public List<Quotation> compareQuotations(@PathVariable String criteria) throws ParseException {
//
//            //return quotation_comparator.compareQuotations(quotations,criteria);
//            return quotation_comparator.compareQuotations(getQuotations(),criteria);
//    }

//    public List<Quotation> getQuotations(){
//        List<Quotation>quotationList = new ArrayList<>();
//        Quotation quotation1 = new Quotation();
//        quotation1.setId((long) 1);
//        quotation1.setQuote_date(java.sql.Date.valueOf("2019-05-15"));
//        quotation1.setDeliveryDate(java.sql.Date.valueOf("2019-05-25"));
//        quotation1.setStatus("Approved");
//        quotation1.setQuoteValidity(java.sql.Date.valueOf("2019-05-25"));
//        quotation1.setTransport(true);
//        quotation1.setDiscount((float) 20.2);
//        quotation1.setTotalPrice((float) 8900.12);
//        quotation1.setItems(getItems1());
//        quotation1.setPurchaseorder(getPurchaseOrder1());
//
//        quotationList.add(quotation1);
//        System.out.println(quotation1.getTotalPrice()+"!*!");
//
//        Quotation quotation2 = new Quotation();
//        quotation2.setId((long) 2);
//        quotation2.setQuote_date(java.sql.Date.valueOf("2019-06-15"));
//        quotation2.setDeliveryDate(java.sql.Date.valueOf("2019-06-25"));
//        quotation2.setStatus("Approved");
//        quotation2.setQuoteValidity(java.sql.Date.valueOf("2019-06-25"));
//        quotation2.setTransport(true);
//        quotation2.setDiscount((float) 23.2);
//        quotation2.setTotalPrice((float) 5170.4);
//        quotation2.setItems(getItems2());
//        quotation2.setPurchaseorder(getPurchaseOrder2());
//        System.out.println(quotation2.getTotalPrice()+"!*!");
//        quotationList.add(quotation2);
//        return quotationList;
//    }
//    public List<Item> getItems1(){
//        List<Item> items = new ArrayList<>();
//        Item item1 = new Item();
//        item1.setId((long) 12);
//        item1.setDescription("Item 1");
//        item1.setName("Name Item1");
//        item1.setQuantity(5);
//        item1.setPrice((float) 1023.0);
//
//        Item item2 = new Item();
//        item2.setId((long) 13);
//        item2.setDescription("Item 2");
//        item2.setName("Name Item2");
//        item2.setQuantity(4);
//        item2.setPrice((float) 4050.0);
//        items.add(item1);
//        items.add(item2);
//        return items;
//    }
//    public List<Item> getItems2(){
//        List<Item> items = new ArrayList<>();
//        Item item1 = new Item();
//        item1.setId((long) 112);
//        item1.setDescription("Item 1");
//        item1.setName("Name Item1");
//        item1.setQuantity(5);
//        item1.setPrice((float) 1563.0);
//
//        Item item2 = new Item();
//        item2.setId((long) 134);
//        item2.setDescription("Item 2");
//        item2.setName("Name1 Item2");
//        item2.setQuantity(4);
//        item2.setPrice((float) 4900.0);
//        items.add(item1);
//        items.add(item2);
//        return items;
//    }
//    public Purchaseorder getPurchaseOrder1(){
//        Purchaseorder purchaseorder = new Purchaseorder();
//        purchaseorder.setId((long) 112);
//        purchaseorder.setQuote_date(java.sql.Date.valueOf("2019-05-15"));
//        purchaseorder.setDate(java.sql.Date.valueOf("2019-05-19"));
//        purchaseorder.setStatus("Done");
//        purchaseorder.setComments("Nil");
//        purchaseorder.setInvoice(getInvoice1());
//        return purchaseorder;
//    }
//    public Purchaseorder getPurchaseOrder2(){
//        Purchaseorder purchaseorder = new Purchaseorder();
//        purchaseorder.setId((long) 1102);
//        purchaseorder.setQuote_date(java.sql.Date.valueOf("2019-06-15"));
//        purchaseorder.setDate(java.sql.Date.valueOf("2019-06-19"));
//        purchaseorder.setStatus("Done");
//        purchaseorder.setComments("Nil");
//        purchaseorder.setInvoice(getInvoice2());
//        return purchaseorder;
//    }
//    public Invoice getInvoice1(){
//        java.util.Date date1 = java.sql.Date.valueOf("2019-06-15");
//        java.util.Date date2 = java.sql.Date.valueOf("2019-06-05");
//        Invoice invoice = new Invoice();
//        invoice.setId((long) 1);
//        invoice.setDate((Date) date1);
//        invoice.setQuote_date((Date) date2);
//        invoice.setStatus("Completed");
//        return invoice;
//    }
//
//    public Invoice getInvoice2(){
//        java.util.Date date1 = java.sql.Date.valueOf("2019-07-15");
//        java.util.Date date2 = java.sql.Date.valueOf("2019-07-05");
//        Invoice invoice = new Invoice();
//        invoice.setId((long) 2);
//        invoice.setDate((Date) date1);
//        invoice.setQuote_date((Date) date2);
//        invoice.setStatus("Completed");
//        return invoice;
//    }

}
