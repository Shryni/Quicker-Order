package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.payload.UserIdentityAvailability;
import com.nci.cad.quickerorder.payload.UserSummary;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import com.nci.cad.quickerorder.security.CurrentUser;
import com.nci.cad.quickerorder.security.RequestorStorePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RequestorStore_Repository requestorStore_repository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser RequestorStorePrincipal requestorStorePrincipal) {
        UserSummary userSummary = new UserSummary(requestorStorePrincipal.getId(), requestorStorePrincipal.getUsername(), requestorStorePrincipal.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !requestorStore_repository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !requestorStore_repository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

}
