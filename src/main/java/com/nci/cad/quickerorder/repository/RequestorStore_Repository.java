package com.nci.cad.quickerorder.repository;


import com.nci.cad.quickerorder.model.RequestorStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestorStore_Repository extends JpaRepository<RequestorStore,Long> {

    Optional<RequestorStore> findByEmail(String email);

    Optional<RequestorStore> findByUsernameOrEmail(String username, String email);

    List<RequestorStore> findByIdIn(List<Long> userIds);

    Optional<RequestorStore> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
