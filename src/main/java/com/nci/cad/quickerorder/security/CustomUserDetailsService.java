package com.nci.cad.quickerorder.security;

import com.nci.cad.quickerorder.exception.ResourceNotFoundException;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        RequestorStore requestorStore = requestorStore_repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return RequestorStorePrincipal.create(requestorStore);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        RequestorStore requestorStore = requestorStore_repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return RequestorStorePrincipal.create(requestorStore);
    }
}