package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class RequestorStore_Service {

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    public List<RequestorStore> getAllRequestorStores() {
        return requestorStore_repository.findAll();
    }

    public ResponseEntity<RequestorStore> addRequestorStore(RequestorStore requestorStore) throws URISyntaxException {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return ResponseEntity.created(new URI("/quickerorder/addRequestorStore/" + requestorStore1.getId()))
                .body(requestorStore1);
    }

    public ResponseEntity<RequestorStore> updateRequestorStore(RequestorStore requestorStore) {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return ResponseEntity.ok().body(requestorStore1);
    }

}
