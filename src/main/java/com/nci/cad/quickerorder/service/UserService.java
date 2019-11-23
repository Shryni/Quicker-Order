package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
}
