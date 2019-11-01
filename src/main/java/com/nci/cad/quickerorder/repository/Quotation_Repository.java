package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.Requestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quotation_Repository extends JpaRepository<Requestor , Long> {
}
