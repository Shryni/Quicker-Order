package com.nci.cad.quickerorder.repository;


import com.nci.cad.quickerorder.model.RequestorStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestorStore_Repository extends JpaRepository<RequestorStore,Long> {
    //RequestorStore findByName(String name);


//    @Query("Select * FROM quicker_order.requestor_store rs WHERE rs.name = ?1")
//    RequestorStore findByName(String name);
}
