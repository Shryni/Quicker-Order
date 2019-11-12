package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
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

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    public List<Requestor> getRequestorByStoreID(Long requestorstoreId) {
        List<Requestor> requestors = requestor_repository.findByRequestorStoreId(requestorstoreId);
        return requestors;
    }

    public List<Requestor> getAll() {
        List<Requestor> requestors = requestor_repository.findAll();
        return requestors;
    }

    public Requestor getRequestorById(Long requestorId) {
        return requestor_repository.findById(requestorId).get();
    }

    public Requestor addRequestor(Requestor requestor, Long requestorStoreId) throws URISyntaxException {
        RequestorStore requestorStore = requestorStore_repository.findById(requestorStoreId).get();
        requestor.setRequestorStore(requestorStore);
        Requestor requestor1 = requestor_repository.save(requestor);
        return requestor1;
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
