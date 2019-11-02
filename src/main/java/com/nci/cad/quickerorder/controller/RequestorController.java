package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.service.Requestor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/requestor")
public class RequestorController {
    @Autowired
    Requestor_Service requestor_service;

    @GetMapping("/getAll")
    public List<Requestor> getAll(){
        return requestor_service.getAll();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Requestor> getRequestor(@Valid @PathVariable long id){
        return requestor_service.getRequestor(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Requestor> addRequestor(@Valid @RequestBody Requestor requestor) throws URISyntaxException {
        return requestor_service.addRequestor(requestor);
    }

   @PutMapping ("/add/{id}")
    public ResponseEntity<Requestor> updateRequestor(@Valid @RequestBody Requestor requestor){
        return requestor_service.updateRequestor(requestor);
   }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRequestor( @Valid @PathVariable Long id) {
        return requestor_service.deleteRequestor(id);
    }
}
