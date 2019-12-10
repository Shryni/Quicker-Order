package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface Quotation_Repository extends JpaRepository<Quotation, Long> {
    Quotation findByVendorPRId(Long id);
    @Query(value = "select count(purchaserequisition_id) from vendorpr a join purchase_requisition b\n" +
            "on a.purchaserequisition_id=b.id join quotation quot on quot.vendorprid=a.id\n" +
            "where requestor_id= :requesterId and a.vendorstore_id= :vendorStoreId ", nativeQuery = true)
    int findQuotationByPurchaserequitionId(@Param("requesterId") Long requesterId ,
                                           @Param("vendorStoreId") Long vendorStoreId);

    @Query("select q from Quotation q WHERE q.status =:status AND q.vendorPR " +
            "IN(SELECT v FROM VendorPR v WHERE v.purchaseRequisition " +
            "IN(SELECT pr FROM PurchaseRequisition pr WHERE pr.requestor in " +
            "(SELECT r from Requestor r where r.id =:requesterId)))")
    List<Quotation> findUsingRequestorIdAndStatus(@Param("requesterId") Long requesterId, @Param("status") String status);


}
