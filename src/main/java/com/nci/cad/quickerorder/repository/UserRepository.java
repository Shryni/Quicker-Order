package com.nci.cad.quickerorder.repository;

import com.nci.cad.quickerorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}