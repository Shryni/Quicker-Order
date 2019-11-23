package com.nci.cad.quickerorder.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}