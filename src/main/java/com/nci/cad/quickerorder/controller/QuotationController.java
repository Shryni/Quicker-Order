package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.*;
import com.nci.cad.quickerorder.payload.JwtAuthenticationResponse;
import com.nci.cad.quickerorder.service.Quotation_Comparator;
import com.nci.cad.quickerorder.service.Quotation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/quotation")
public class QuotationController {


    @Autowired
    Quotation_Service quotation_service;

    @Autowired
    Quotation_Comparator quotation_comparator;

    ResponseEntity responseEntity = null;

    //*****************************************************************************//
    @GetMapping("/view")
    public String viewQuotation() {
        return "quotation/th_viewRequestorStore.html";
    }

    @GetMapping("/add")
    public String addQuotation() {
        return "quotation/th_addRequestorStore.html";
    }

    @GetMapping("/edit")
    public String editQuotation() {
        return "quotation/edit.html";
    }
    //*****************************************************************************//

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

    @PostMapping("/{vprID}/new")
    public ResponseEntity<Quotation> addQuotation(@PathVariable (value = "vprID") Long vprID, @Valid @RequestBody Quotation quotation) throws URISyntaxException {
        Quotation quotation1 = quotation_service.addQuotation(vprID,quotation);
        if(quotation1 != null){
            return responseEntity.status(HttpStatus.OK).body(quotation1);
        }
        else{
            return (ResponseEntity<Quotation>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
//    @GetMapping("/{prID}/all")
//    public ResponseEntity<List<Quotation>> getVendorQuotations(@PathVariable (value = "prID") Long prID) throws URISyntaxException {
//        List<Quotation> quotationList = quotation_service.getAllQuotationsforVendor(prID);
//        if(quotationList != null){
//            return responseEntity.status(HttpStatus.OK).body(quotationList);
//        }
//        else{
//            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuotation( @Valid @PathVariable Long id) {
        return quotation_service.deleteQuotation(id);
    }

    @GetMapping("/compare/{criteria}")
    public ResponseEntity<List<Quotation>> compareQuotations(@Valid @RequestBody List<Quotation> quotations ,@PathVariable String criteria) throws ParseException {
        List<Quotation> quotationList = null;
        if(quotations.size()>3)
            return (ResponseEntity<List<Quotation>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        else
            quotationList = quotation_comparator.compareQuotations(quotations,criteria);
            return responseEntity.status(HttpStatus.OK).body(quotationList);
    }
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
