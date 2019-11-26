package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.exception.AppException;
import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.model.Role;
import com.nci.cad.quickerorder.model.RoleName;
import com.nci.cad.quickerorder.payload.ApiResponse;
import com.nci.cad.quickerorder.payload.JwtAuthenticationResponse;
import com.nci.cad.quickerorder.payload.LoginRequest;
import com.nci.cad.quickerorder.payload.SignUpRequest;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import com.nci.cad.quickerorder.repository.Role_Repository;
import com.nci.cad.quickerorder.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RequestorStore_Repository requestorStore_repository;

    @Autowired
    Role_Repository role_repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateStore(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerStore(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(requestorStore_repository.existsByUsername(signUpRequest.getUsername())) {
           // System.out.println("Username is already taken!");
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(requestorStore_repository.existsByEmail(signUpRequest.getEmail())) {
           // System.out.println("Email Address already in use!");
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating store's account
        RequestorStore requestorStore = new RequestorStore(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        requestorStore.setPassword(passwordEncoder.encode(requestorStore.getPassword()));
        Role userRole = null;

        if(signUpRequest.getUsername().contains("ADMIN")||signUpRequest.getName().contains("admin")){
            userRole = role_repository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new AppException("Admin Role not set."));
        }
        else{
            userRole = role_repository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new AppException("User Role not set."));
        }

        requestorStore.setRoles(Collections.singleton(userRole));

        RequestorStore result = requestorStore_repository.save(requestorStore);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Store registered successfully"));
    }
}


