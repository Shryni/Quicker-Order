package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Requestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Requestor_Repository extends JpaRepository<Requestor ,Long> {

    List<Requestor> findByRequestorStoreId(Long id);
    List<Requestor> findByRequestorStoreName(String name);

}
