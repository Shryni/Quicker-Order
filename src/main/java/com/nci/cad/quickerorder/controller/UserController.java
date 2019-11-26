package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.payload.EmailCheck;
import com.nci.cad.quickerorder.payload.UserIdentityAvailability;
import com.nci.cad.quickerorder.payload.UserNameCheck;
import com.nci.cad.quickerorder.payload.UserSummary;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import com.nci.cad.quickerorder.security.CurrentUser;
import com.nci.cad.quickerorder.security.RequestorStorePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RequestorStore_Repository requestorStore_repository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    ResponseEntity responseEntity = null;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser RequestorStorePrincipal requestorStorePrincipal) {
        UserSummary userSummary = new UserSummary(requestorStorePrincipal.getId(), requestorStorePrincipal.getUsername(), requestorStorePrincipal.getName());
        return userSummary;
    }

//    @GetMapping("/user/checkUsernameAvailability")
//    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
//        Boolean isAvailable = !requestorStore_repository.existsByUsername(username);
//        return new UserIdentityAvailability(isAvailable);
//    }

//    @GetMapping("/user/checkEmailAvailability")
//    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
//        Boolean isAvailable = !requestorStore_repository.existsByEmail(email);
//        return new UserIdentityAvailability(isAvailable);
//    }

    @PostMapping("/user/checkEmailAvailability")
    public ResponseEntity<?> checkEmailAvailability (@Valid @RequestBody EmailCheck email){
        Boolean isAvailable = !requestorStore_repository.existsByEmail(email.getEmailValue());
        return ResponseEntity.ok(new EmailCheck(null,isAvailable));
    }

    @PostMapping("/user/checkUsernameAvailability")
    public ResponseEntity<?> checkUsernameAvailability(@Valid @RequestBody UserNameCheck username) {
        Boolean isAvailable = !requestorStore_repository.existsByUsername(username.getUserNameValue());
        return ResponseEntity.ok(new UserNameCheck(null,isAvailable));
    }

}
