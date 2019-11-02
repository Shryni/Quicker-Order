package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class RequestorStore_Service {

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    public List<RequestorStore> getAllRequestorStores() {
        return requestorStore_repository.findAll();
    }

    public ResponseEntity<RequestorStore> addRequestorStore(RequestorStore requestorStore) throws URISyntaxException {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return ResponseEntity.created(new URI("/requestorStore/add/" + requestorStore1.getId()))
                .body(requestorStore1);
    }

    public ResponseEntity<RequestorStore> updateRequestorStore(RequestorStore requestorStore) {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return ResponseEntity.ok().body(requestorStore1);
    }

    public ResponseEntity<RequestorStore> getRequestorStore(long id) {
        Optional<RequestorStore> requestorStore = requestorStore_repository.findById(id);
        return requestorStore.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<?> deleteRequestorStore(Long id) {
        requestorStore_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
