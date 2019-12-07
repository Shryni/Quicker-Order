package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.payload.Spending;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Service
public class Quotation_Service {
    @Autowired
    Quotation_Repository quotation_repository;

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_Repository;

    public List<Quotation> getAll() {
        return quotation_repository.findAll();
    }
    public Quotation getQuotationByID(long id) {
        return quotation_repository.findById(id).get();
    }

    public Quotation addQuotation(Long vendorPRID, Quotation quotation) throws URISyntaxException {
        VendorPR vendorPR = vendorPR_repository.findById(vendorPRID).get();
        quotation.setVendorPR(vendorPR);
        return quotation_repository.save(quotation);
    }
    public List<Quotation> getAllQuotationsforVendor(Long prID) {
        return quotation_repository.findByVendorPRId(prID);
    }

    public Quotation approveQuotation(Long quotationID) {
        Quotation quotation = quotation_repository.findById(quotationID).get();
        //quotation.setStatus(true);
        return quotation_repository.save(quotation);
    }
    public ResponseEntity<?> deleteQuotation(Long id) {
        quotation_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    public List<Quotation> getSpendingsByRequestors(Long requestorID, String status) {
////        /*List<PurchaseRequisition> purchaseRequisitions = purchaseRequisition_Repository.findByRequestorId(requestorID);
////        List<Long> purchaseRequisitionIds = new ArrayList<>();
////        purchaseRequisitions.stream().forEach(p -> purchaseRequisitionIds.add(p.getId()));*/
////
////        return quotation_repository.findUsingRequestorIdAndStatus(requestorID, status);
////
////    }
////
    public List<Quotation> getQuotationsbyprID(Long prID) {
        return quotation_repository.findByVendorPRId(prID);
    }

    public List<Spending> getSpendingsByRequestors(Long requestorID, String status) {

        List<Quotation> quotations = quotation_repository.findUsingRequestorIdAndStatus(requestorID, status);

        List<Spending> spendings = new ArrayList<>();

        for(Quotation q: quotations){

            Spending spend = new Spending();
            spend.setDeliveryDate(q.getDeliveryDate());
            spend.setTotalPrice(q.getTotalPrice());

            spendings.add(spend);
        }
        return spendings;
    }


//    public List<Quotation> getQuotationsbyprID(Long prID) {
//    }
}
