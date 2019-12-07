package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.*;
import com.nci.cad.quickerorder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyDiscount {
    @Autowired
    Invoice_Repository invoice_repository;

    @Autowired
    PurchaseOrder_Repository po_repository;

    @Autowired
    Quotation_Repository quotation_repository;

    @Autowired
    PurchaseRequisition_Repository purchase_requisition_repository;

    @Autowired
    Requestor_Repository requestor_repository;

    public Quotation addDiscountToQuotation(Long reqID, Long vendorId, Quotation finalizedQuatation) {
        List<PurchaseRequisition> purchaseRequestionList = purchase_requisition_repository.findByRequestorId(reqID);
        ArrayList<Long> purchaseRequrstionIdList = new ArrayList();
        Integer size=0;

        for (PurchaseRequisition purchaseRequisition : purchaseRequestionList) {
            purchaseRequrstionIdList.add(purchaseRequisition.getId());
        }

        if (!purchaseRequrstionIdList.isEmpty()) {
            size= getInvoiceSizeForRequestorIdAndVendorId(purchaseRequrstionIdList,size, reqID, vendorId);
        }

        if(size>2)
        {
            finalizedQuatation.setDiscount((float) (finalizedQuatation.getTotalPrice()*0.95));
        }else
        {
            finalizedQuatation.setDiscount(finalizedQuatation.getTotalPrice());
        }

        return finalizedQuatation;
    }

    private Integer getInvoiceSizeForRequestorIdAndVendorId(ArrayList<Long> purchaseRequrstionIdList, Integer size, Long id, Long vendorId) {

        List<Quotation> quotationList = quotation_repository.findQuotationByPurchaserequitionId(purchaseRequrstionIdList);

        ArrayList<Long> quotationIdList = new ArrayList();

        for (Quotation quote : quotationList) {
            if(quote.getPurchase_requisition().getRequestor().getId()==id && quote.getVendorPR().getId()==vendorId)
            {
                quotationIdList.add(quote.getId());
            }

        }

        if (!quotationIdList.isEmpty()) {
            List<Purchaseorder> poList = po_repository.findAllById(quotationIdList);
            ArrayList<Long> poIDList = new ArrayList();
            for (Purchaseorder po : poList) {
                poIDList.add(po.getId());
            }

            if (!poIDList.isEmpty()) {
                List<Invoice> invList = invoice_repository.findAllById(poIDList);
                size=invList.size();
            }
        }

        return size;
    }
}





