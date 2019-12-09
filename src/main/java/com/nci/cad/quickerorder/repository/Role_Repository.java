package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.model.Role;
import com.nci.cad.quickerorder.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Role_Repository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
