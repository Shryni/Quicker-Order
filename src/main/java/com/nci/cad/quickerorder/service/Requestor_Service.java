package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.repository.Requestor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class Requestor_Service {

    @Autowired
    Requestor_Repository requestor_repository;

    public List<Requestor> getAll() {
        return requestor_repository.findAll();
    }

    public ResponseEntity<Requestor> getRequestor(long id) {
        Optional<Requestor> requestor = requestor_repository.findById(id);
        return requestor.map(requestor1-> ResponseEntity.ok().body(requestor1))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Requestor> addRequestor(Requestor requestor) throws URISyntaxException {
        Requestor requestor1 = requestor_repository.save(requestor);
        return ResponseEntity.created(new URI("/requestor/add/"+requestor1.getId())).body(requestor1);
    }

    public ResponseEntity<Requestor> updateRequestor(Requestor requestor) {
        Requestor requestor1 = requestor_repository.save(requestor);
        return ResponseEntity.ok().body(requestor1);
    }

    public ResponseEntity<?> deleteRequestor(Long id) {
        requestor_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
