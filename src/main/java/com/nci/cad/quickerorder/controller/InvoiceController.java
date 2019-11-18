package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.model.Purchaseorder;
import com.nci.cad.quickerorder.service.Invoice_Service;
import com.nci.cad.quickerorder.service.Spendings_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/invoice")

public class InvoiceController {

    @Autowired
    Invoice_Service invoice_service;

    @Autowired
    Spendings_Service spendings_service;

    ResponseEntity responseEntity = null;

    @GetMapping("/all")
    public ResponseEntity<List<Invoice>> getAll(){
        List<Invoice> invoices = invoice_service.getAll();
        if(invoices != null){
            return responseEntity.status(HttpStatus.OK).body(invoices);
        }
        else{
            return (ResponseEntity<List<Invoice>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{invoiceID}")
    public ResponseEntity<Invoice> getInvoicebyID(@PathVariable (value = "invoiceID")Long invoiceID){
        Invoice invoice = invoice_service.getInvoice(invoiceID);
        if(invoice != null){
            return responseEntity.status(HttpStatus.OK).body(invoice);
        }
        else {
            return (ResponseEntity<Invoice>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{poID}/new")
    public ResponseEntity<Invoice> addInvoice(@PathVariable (value = "poID") Long poID, @Valid @RequestBody Invoice invoice) throws URISyntaxException {
        Invoice invoice1 = invoice_service.addInvoice(poID,invoice);
        if(invoice1 != null){
            return responseEntity.status(HttpStatus.OK).body(invoice1);
        }
        else{
            return (ResponseEntity<Invoice>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getMonthlyExpense/{startDate}/{endDate}")
    public ResponseEntity<?> getMonthlyExpense (@Valid @PathVariable String startDate , @PathVariable String endDate){

        return spendings_service.getMonthlyExpense(invoice_service.getAll(), startDate, endDate);
    }
}
