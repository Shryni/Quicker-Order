package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.dto.RequestorDTO;
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

    @GetMapping("/{requestorstoreId}/getRequestor")
    public List<Requestor> getAll(@PathVariable (value = "requestorstoreId")Long requestorstoreId) {
        return requestor_service.getAll(requestorstoreId);
    }

    @GetMapping("/{requestorstoreId}/getRequestor/{requestorId}")
    public Requestor getRequestorById(@PathVariable (value = "requestorstoreId")Long requestorstoreId,@PathVariable (value = "requestorId")Long requestorId){
        return requestor_service.getRequestorById(requestorstoreId,requestorId);
    }

    @PostMapping("/{requestorstoreId}/addRequestor")
    public Requestor addRequestor(@PathVariable (value = "requestorstoreId") Long requestorstoreId,@Valid @RequestBody Requestor requestor) throws URISyntaxException {
        return requestor_service.addRequestor(requestor,requestorstoreId);

    }

    @PutMapping("/add/{id}")
    public ResponseEntity<Requestor> updateRequestor(@Valid @RequestBody RequestorDTO requestor) {
        return null;
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRequestor(@Valid @PathVariable Long id) {
        return requestor_service.deleteRequestor(id);
    }
}





//    public ResponseEntity<String> addRequestor(@Valid @RequestBody Requestor requestor, @PathVariable("id") Long id) throws URISyntaxException {
////         requestor_service.addRequestor(
////                Requestor.builder()
////                        .id(requestor.getId())
////                        .first_name(requestor.getFirst_name())
////                        .last_name(requestor.getLast_name())
////                        .role(requestor.getRole())
////                        .role_id(requestor.getRole_id())
////                        .build(), id);
//         requestor_service.addRequestor(requestor,id);
//         return ResponseEntity.ok().body("ok");
//    }
//localhost:8080/requestor/3/add
