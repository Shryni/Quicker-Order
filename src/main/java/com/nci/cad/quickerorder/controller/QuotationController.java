package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.service.Quotation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/quotation")
public class QuotationController {


    @Autowired
    Quotation_Service quotation_service;

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

}
