package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.*;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RequestorStore_Service {

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    public List<RequestorStore> getAllRequestorStores() {
        return requestorStore_repository.findAll();
    }

    public RequestorStore addRequestorStore(RequestorStore requestorStore) throws URISyntaxException {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return requestorStore1;
//        return ResponseEntity.created(new URI("/requestorStore/add/" + requestorStore1.getId()))
//                .body(requestorStore1);
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

//    public Map<Date, Float> getInvoiceDetails(long id) {
//        Optional<RequestorStore> requestorStore = requestorStore_repository.findById(id);
//        RequestorStore requestorStore1 = requestorStore.get();
//        assert requestorStore1 != null;
//        List<Requestor> requestorsList = requestorStore1.getRequestors();
//        Map<Date, Float> invoiceDetails = new LinkedHashMap<>();
//        for(Requestor requestor: requestorsList) {
//            List<PurchaseRequisition> purchaseRequisitionList = requestor.getPurchase_requisitions();
//            for(PurchaseRequisition purchaseRequisition: purchaseRequisitionList){
//                List<Quotation> quotationList = purchaseRequisition.getQuotations();
//                for(Quotation quotation: quotationList){
//                    if(quotation.getStatus().equals("Approved")){
//                        float price = quotation.getTotalPrice();
//                        Purchaseorder purchaseorder = quotation.getPurchaseorder();
//                        Invoice invoice = purchaseorder.getInvoice();
//                        Date invoiceDate = (Date) invoice.getDate();
//                        invoiceDetails.put(invoiceDate,price);
//                    }
//                }
//            }
//
//        }
//        return invoiceDetails;
//    }
}
