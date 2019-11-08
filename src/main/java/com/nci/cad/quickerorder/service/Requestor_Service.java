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

    public List<Requestor> getAll(Long requestorStoreID) {
        List<Requestor> requestors = requestor_repository.findByRequestorStoreId(requestorStoreID);
        return requestors;
    }

    public Requestor getRequestorById(Long requestorstoreId,Long requestorId) {
        Requestor requestorbyID = null;
        List<Requestor> requestors = requestor_repository.findByRequestorStoreId(requestorstoreId);
        for (Requestor requestor: requestors
             ) {
            if(requestor.getId() == requestorId){
                requestorbyID = requestor;
            }
        }
        return requestorbyID;
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

//    public ResponseEntity<Requestor> getRequestor(long id) {
//        Optional<Requestor> requestor = requestor_repository.findById(id);
//        return requestor.map(requestor1-> ResponseEntity.ok().body(requestor1))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
