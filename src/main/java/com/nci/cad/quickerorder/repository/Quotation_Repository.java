package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Quotation_Repository extends JpaRepository<Quotation, Long> {
    //List<Quotation> findByPurchaseOrderId(Long id);
    List<Quotation> findByVendorPRId(Long id);

    //List<Quotation> fin
   @Modifying(clearAutomatically = true)
    @Query("Update Quotation quotation set quotation.totalPrice =0.95*totalPrice where quotation.id =:quoteID")
    void addDiscountToQuotation_repository(@Param("quoteID") Long quotationID);

    @Query("select quotation from Quotation quotation where quotation.purchase_requisition in :Ids")
    List<Quotation> findQuotationByPurchaserequitionId(@Param("Ids") List<Long> ids);

//    @Query("select * from Quotation quotation where quotation.purchase_requisition in :Id")
//    List<Quotation> findQuotationByPurchaserequitionId(@Param("Id") Long ID);


    // List<Quotation> findByPurchase__requisition(Long id);

   @Query("select q from Quotation q WHERE q.status =:status AND q.purchase_requisition IN(SELECT pr FROM PurchaseRequisition pr WHERE pr.requestor in (SELECT r from Requestor r where r.id =:requesterId))")
   List<Quotation> findUsingRequestorIdAndStatus(@Param("requesterId") Long requesterId, @Param("status") String status);

/*    @Query("select * from Quotation q where q.")
    List<Quotation> findAllByPurchaseRequisitionId(List<Long> ids);*/


}
