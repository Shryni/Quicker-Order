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
  /*  @Modifying(clearAutomatically = true)
    @Query("Update Quotation quotation set quotation.totalPrice =0.95*totalPrice where quotation.id =:quoteID")
    void addDiscountToQuotation_repository(@Param("quoteID") Long quotationID);

    @Query("select * from  Quotation quotation where quotation.purchase_requisition in :Ids")
    List<Quotation> findQuotationByPurchaserequitionId(@Param("Ids") List<Long> ids);*/
}
