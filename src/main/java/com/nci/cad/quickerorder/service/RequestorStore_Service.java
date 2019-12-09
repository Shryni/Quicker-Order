package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.payload.StoreUpdateObject;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class RequestorStore_Service {

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    public List<RequestorStore> getAllRequestorStores() {
        return requestorStore_repository.findAll();
    }
    public RequestorStore getRequestorStore(long id) {
        return requestorStore_repository.findById(id).get();
    }

    public RequestorStore addRequestorStore(RequestorStore requestorStore) throws URISyntaxException {
        RequestorStore requestorStore1 = requestorStore_repository.save(requestorStore);
        return requestorStore1;
    }

    public RequestorStore  updateRequestorStore(StoreUpdateObject requestorStore) {
        RequestorStore requestorStore1 = requestorStore_repository.findByName(requestorStore.getName()).get();
        requestorStore1.setName(requestorStore.getName());
        requestorStore1.setEmail(requestorStore.getEmail());
        requestorStore1.setStoreAddress_line1(requestorStore.getStoreAddress_line1());
        requestorStore1.setStoreAddress_line2(requestorStore.getStoreAddress_line2());
        requestorStore1.setStoreAddress_line3(requestorStore.getStoreAddress_line3());
        requestorStore1.setApproval_limit(requestorStore.getApproval_limit());
        requestorStore1.setStore_city(requestorStore.getStore_city());
        requestorStore1.setStore_postal_code(requestorStore.getStore_postal_code());
        requestorStore1.setStore_contact(requestorStore.getStore_contact());
        requestorStore1.setDelivery_address(requestorStore.getDeliveryAddress());


        return requestorStore_repository.save(requestorStore1);


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
