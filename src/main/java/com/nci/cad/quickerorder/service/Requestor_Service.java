package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.payload.NewRequestor;
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

    public List<Requestor> getAllbyID(Long id) {
        List<Requestor> requestors = requestor_repository.findByRequestorStoreId(id);
        return requestors;
    }

    public Requestor getRequestorById(Long requestorId) {
        return requestor_repository.findById(requestorId).get();
    }

    public Requestor addRequestor(NewRequestor newRequestor) throws URISyntaxException {
        RequestorStore requestorStore = requestorStore_repository.findById(newRequestor.getStoreID()).get();

        Requestor requestor = new Requestor();
        requestor.setRequestorStore(requestorStore);
        requestor.setFirst_name(newRequestor.getFirst_name());
        requestor.setLast_name(newRequestor.getLast_name());
        requestor.setRole(newRequestor.getRole());
        requestor.setRequestor_email(newRequestor.getEmail());
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

    public List<Requestor> getAllRequestors(String username) {
        return requestor_repository.findByRequestorStoreName(username);
    }
}
