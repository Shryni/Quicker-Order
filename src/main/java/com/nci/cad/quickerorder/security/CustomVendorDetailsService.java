package com.nci.cad.quickerorder.security;

import com.nci.cad.quickerorder.exception.ResourceNotFoundException;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.repository.VendorStore_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomVendorDetailsService implements UserDetailsService {

    @Autowired
    VendorStore_Repository vendorStore_repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        VendorStore vendorStore = vendorStore_repository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(()->
                        new UsernameNotFoundException("User not found with username or email : \" + usernameOrEmail"));

        return VendorStorePrincipal.create(vendorStore);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        VendorStore vendorStore = vendorStore_repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return VendorStorePrincipal.create(vendorStore);
    }
}
