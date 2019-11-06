package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.service.Quotation_Comparator;
import com.nci.cad.quickerorder.service.Quotation_Service;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/quotation")
public class QuotationController {


    @Autowired
    Quotation_Service quotation_service;

    @Autowired
    Quotation_Comparator quotation_comparator;

    @GetMapping("/getAll")
    public List<Quotation> getAll(){
        return quotation_service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Quotation> getQuotation(@Valid @PathVariable long id){
        return quotation_service.getQuotation(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Quotation> addQuotation(@Valid @RequestBody Quotation quotation) throws URISyntaxException {
        return quotation_service.addQuotation(quotation);
    }

    @PutMapping ("/add/{id}")
    public ResponseEntity<Quotation> updateQuotation (@Valid @RequestBody Quotation quotation){
        return quotation_service.updateQuotation(quotation);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuotation( @Valid @PathVariable Long id) {
        return quotation_service.deleteQuotation(id);
    }

    @GetMapping("/compare/{criteria}")
    public ResponseEntity<List<Quotation>> compareQuotations(@Valid @RequestBody List<Quotation> quotations ,@PathVariable String criteria) throws ParseException {
        if(quotations.size()>3)
            return null;
        else
            return quotation_comparator.compareQuotations(quotations,criteria);
    }

}
