package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Item;
import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.payload.*;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import com.sun.org.apache.xpath.internal.operations.Quo;
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
public class    Quotation_Service {
    @Autowired
    Quotation_Repository quotation_repository;

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_Repository;

    @Autowired
    ApplyDiscount applyDiscount;

    public List<Quotation> getAll() {
        return quotation_repository.findAll();
    }
    public Quotation getQuotationByID(long id) {
        return quotation_repository.findById(id).get();
    }

    public Quotation addQuotation(NewQuotation newQuotation) throws URISyntaxException {
        Quotation quotation = new Quotation();
        quotation.setQuote_date(newQuotation.getQuote_date());
        quotation.setStatus("Submitted");
        quotation.setDeliveryDate(newQuotation.getDeliveryDate());
        quotation.setQuoteValidity(newQuotation.getQuoteValidity());
        if(newQuotation.getCheckedFeatures().contains("Basic Transportation Cost")){
            quotation.setTransport(true);
        }
        else{
            quotation.setTransport(false);
        }
        if(newQuotation.getCheckedFeatures().contains("New Customer Discount"))
        {
            quotation.setDiscount((float) 0.15);
        }
        if(newQuotation.getCheckedFeatures().contains("Regular Customer Discount"))
        {
            quotation.setDiscount(quotation.getDiscount()+(float) 0.15);
        }
        quotation.setInitialPrice((float) newQuotation.getInitialPrice());
        quotation.setTotalPrice((float) newQuotation.getPrice());
        VendorPR vendorPR = vendorPR_repository.findById(newQuotation.getVendorPRID()).get();
        quotation.setVendorPR(vendorPR);
        Quotation quotationwithNewPrice = applyDiscount.addDiscountToQuotation(
                quotation.getVendorPR().getPurchaseRequisition().getRequestor().getId(),
                quotation.getVendorPR().getVendorStore().getId(),
                quotation
        );
        quotation.setTotalPrice(quotationwithNewPrice.getTotalPrice());
        return quotation_repository.save(quotation);
    }


    public Quotation approveQuotation(Long quotationID) {
        Quotation quotation = quotation_repository.findById(quotationID).get();
        quotation.setStatus("Approved");
        return quotation_repository.save(quotation);
    }
    public ResponseEntity<?> deleteQuotation(Long id) {
        quotation_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }



    public List<QuotationResponse> getAllForPR(Long prID) {
        List<QuotationResponse> returnList = new ArrayList<QuotationResponse>();
        List<VendorPR> vendorPRList = vendorPR_repository.findBypurchaseRequisition_id(prID);
        for (VendorPR vpr : vendorPRList
             ) {
            Quotation quotation = quotation_repository.findByVendorPRId(vpr.getId());
            String vendorName = quotation.getVendorPR().getVendorStore().getName();
            returnList.add(new QuotationResponse(quotation,vendorName));
        }
        return returnList;
    }

    public Double generateQuotationPrice(GeneratePrice generatePrice) {
        ArrayList<String> features = generatePrice.getFeatures();

        QuotationObj vendorQuotation = new VendorQuotation();

        if(features.contains("Basic Transportation Cost")){
            vendorQuotation = new TransportQuotation(vendorQuotation);
        }
        if(features.contains("Fast Track Delivery")){
            vendorQuotation = new FasTrackQuotation(vendorQuotation);
        }
        if(features.contains("New Customer Discount")){
            vendorQuotation = new NewCustomerQuotation(vendorQuotation);
        }
        if(features.contains("Regular Customer Discount")){
            vendorQuotation = new RegularCustomerQuotation(vendorQuotation);
        }
        return vendorQuotation.price(generatePrice.getQuotedPrice());
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

}
