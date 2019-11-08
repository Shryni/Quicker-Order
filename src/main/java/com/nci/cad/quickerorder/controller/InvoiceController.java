package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Invoice;
import com.nci.cad.quickerorder.service.Invoice_Service;
import com.nci.cad.quickerorder.service.Spendings_Service;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAll")
    public List<Invoice> getAll(){
        return invoice_service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Invoice> getInvoice(@Valid @PathVariable long id){
        return invoice_service.getInvoice(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Invoice> addInvoice(@Valid @RequestBody Invoice invoice) throws URISyntaxException {
        return invoice_service.addInvoice(invoice);
    }

    @PutMapping ("/add/{id}")
    public ResponseEntity<Invoice> updateInvoice (@Valid @RequestBody Invoice invoice){
        return invoice_service.updateInvoice(invoice);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInvoice( @Valid @PathVariable Long id) {
        return invoice_service.deleteInvoice(id);
    }

    @GetMapping("/getMonthlyExpense/{startDate}/{endDate}")
    public ResponseEntity<?> getMonthlyExpense (@Valid @PathVariable String startDate , @PathVariable String endDate){

        return spendings_service.getMonthlyExpense(invoice_service.getAll(), startDate, endDate);
    }
}